package singletonmode;

/**
 * 懒汉单例模式
 *
 * @author:whr 2019/7/14
 */
public class Person {
    //私有化构造方法
    private Person() {

    }

    //懒汉模式
    private volatile static Person person;

    public static Person getInstance() {
        if (person == null) {
            synchronized (Person.class) {
                if (person == null) {
                    person = new Person();
                }
            }
        }
        return person;
    }


}
