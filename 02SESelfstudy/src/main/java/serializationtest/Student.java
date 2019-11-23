package serializationtest;

import java.io.Serializable;

/**
 * @author:whr 2019/7/14
 */
public class Student implements Serializable {


    private static final long serialVersionUID = -6092648783124113008L;
    //姓名
    private String name;
    //年龄
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
