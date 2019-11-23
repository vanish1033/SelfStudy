package dontKnow;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author:whr 2019/9/9
 */
public class Common {

    private Common() {
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Test.common = this;
    }

    @org.junit.Test // 测试对象在finalize中的自我救赎
    public void test9() throws IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException {
        Class<Common> commonClass = Common.class;
        Constructor<?> constructor = commonClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        Common o = (Common) constructor.newInstance();
        System.out.println(o);

        Student student = new Student();

        o = null;
        Thread.sleep(1_000);
        System.out.println(this);

/*        sd:
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            break sd;
        }*/

    }
}
