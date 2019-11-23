package juc;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author:whr 2019/11/14
 */
public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        Integer integer = 1000000;

        System.out.println(unsafe.objectFieldOffset(Integer.class.getDeclaredField("value")));

        System.out.println(unsafe.arrayBaseOffset(int[].class));

        System.out.println(unsafe.arrayIndexScale(double[].class));

        System.out.println(unsafe.compareAndSwapInt(integer, 8, 1000000, 2));

        System.out.println(integer);
    }
}
