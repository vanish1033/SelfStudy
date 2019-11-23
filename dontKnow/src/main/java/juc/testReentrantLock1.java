package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:whr 2019/10/23
 */
public class testReentrantLock1 {

    private static final ReentrantLock lock = new ReentrantLock();

    private static int anInt = 0;

    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 10000; i++) {
                new Thread() {
                    @Override
                    public void run() {

                        // anInt = anInt + 1;

                        // synchronized (Object.class) {
                        // anInt++;
                        // }

                        try {
                            lock.lock();
                            condition.await();
                            anInt++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                        }

                    }
                }.start();
            }

            Thread.sleep(40);

            System.out.println(anInt);
        }
    }

}
