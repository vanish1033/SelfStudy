package juc.unsafetest;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import dontKnow.Student;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:whr 2019/11/14
 */
public class Test {

    public static student student = new student();

    public static Unsafe unsafe;

    private static CountDownLatch countDownLatch = new CountDownLatch(2);
    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, InterruptedException {

        long ageOffset = unsafe.objectFieldOffset(student.class.getDeclaredField("age"));

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    int age = student.getAge();
                    boolean flag = unsafe.compareAndSwapInt(student, ageOffset, age, age + 1);
                    if (!flag) i--;
                }
                countDownLatch.countDown();
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    int age = student.getAge();
                    boolean flag = unsafe.compareAndSwapInt(student, ageOffset, age, age + 1);
                    if (!flag) i--;
                }
                countDownLatch.countDown();
            }
        }.start();

        countDownLatch.await();

        System.out.println(student.getAge());

    }

}
