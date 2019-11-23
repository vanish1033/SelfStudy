package multithreadedreordering;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

/**
 * @author:whr 2019/7/22
 */
public class Test {

    public static boolean flag;
    public static int num;

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
}
