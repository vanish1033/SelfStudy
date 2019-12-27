package dontKnow;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 枚举单例
 *
 * @author:whr 2019/9/8
 */
public class Single {

    private Single() {
    }

    public static Single getIntance() {
        return Singleton.INSTANCE.getSingle();
    }

    private enum Singleton {

        INSTANCE;

        private Single single;

        Singleton() {
            single = new Single();
        }

        private Single getSingle() {
            return this.single;
        }

    }

//    private Single() {
//    }
//
//    public static Single getIntance() {
//        return Singleton.INSTANCE.getSingleTest();
//    }
//
//    private enum Singleton {
//
//        INSTANCE;
//
//        Singleton() {
//            singleTest = new Single();
//        }
//
//        private Single singleTest;
//
//        private Single getSingleTest() {
//            return singleTest;
//        }
//
//    }

}
