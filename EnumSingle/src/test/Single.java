package test;

/**
 * 使用枚举实现单例
 *
 * @author:whr 2019/8/22
 */
public class Single {

    private Single() {

    }

    public static Single getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    /**
     * 枚举类
     */
    private enum Singleton {
        /**
         * 枚举里的每一个值，比如下面的INSTANCE，都是一个自身类型的引用，
         * 反编译后就是static final的一个引用，比如public static final a = new a();
         * static变量在类加载的时候执行，并且在初始化的时候执行INSTANCE的赋值，也就是创建一个
         * 自身的对象赋值给INSTANCE，这时会调用枚举的构造方法，由于Singleton枚举里的值只有一个INSTANCE
         * 所以这个构造方法也就只会执行一次
         * （这个构造方法是在INSTANCE被用到的时候触发的类加载过程中被执行，而类加载过程是由JVM保证线程安全的），
         * 我们把创建对象对象的代码放到里面，就自然只会执行一次，创建一个对象
         * 另外，枚举实现的单例还能防止反序列化和对象克隆
         */
        INSTANCE;

        private Single single;

        Singleton() {
            single = new Single();
        }

        private Single getSingleton() {
            return single;
        }

    }

}
