package singletonmode;

/**
 * @author:whr 2019/7/14
 */
public class Test {
    public static void main(String[] args) {
        //饿汉模式测试
        Admin admin1 = Admin.getInstance();
        Admin admin2 = Admin.getInstance();
        System.out.println(admin1 == admin2);

        //懒汉模式测试
        Person person1 = Person.getInstance();
        Person person2 = Person.getInstance();
        System.out.println(person1 == person2);

    }
}
