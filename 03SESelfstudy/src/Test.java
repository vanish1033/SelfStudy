
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:whr 2019/7/25
 */
public class Test {
    public static void main(String[] args) {
//        int i = 0xaaaf123a;
//        System.out.println(i);

        Object o = new Object();


        Object o1 = Proxy.newProxyInstance(Object.class.getClassLoader(), Object.class.getInterfaces(), (proxy, method, args1) -> {
            System.out.println("123");
            Object invoke = method.invoke(o, args1);
            return invoke;
        });

        System.out.println("o1.equals(new Object()) = " + o1.equals(new Object()));

    }
}
