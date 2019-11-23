package test;

/**
 * @author:whr 2019/8/23
 */
public class Test {

    @org.junit.Test
    public void test1() {

        Single instance1 = Single.getInstance();
        Single instance2 = Single.getInstance();
        Single instance3 = Single.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance3);

    }
}
