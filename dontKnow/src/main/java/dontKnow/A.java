package dontKnow;

/**
 * @author:whr 2019/11/7
 */
public class A {
    protected int method1(int a, int b) {
        return 0;
    }
}

class B extends A {
//    @Override
    private int method1(int a, long b) {
        return super.method1(a, (int) b);
    }
}
