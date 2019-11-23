package singletonmode;


/**
 * 饿汉单例模式
 *
 * @author:whr 2019/7/14
 */
public class Admin {
    //私有化构造器
    private Admin() {

    }

    //饿汉模式
    private static Admin admin = new Admin();

    public static Admin getInstance() {
        return admin;
    }

}
