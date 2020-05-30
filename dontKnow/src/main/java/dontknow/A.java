package dontknow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:whr 2019/11/7
 */
public class A {

    protected int method1(int a, int b) {
        return 1;
    }

    protected int method1(Integer a, int b) {
        return 2;
    }

    protected int method1(int a, Integer b) {
        return 3;
    }

    public void method2(Map map) {

    }

    public void method2(HashMap map) {

    }
}

//class B extends A {
//
//
////    @Override
//    private int method1(int a, long b) {
//        return super.method1(a, (int) b);
//    }
//}
