package sortbyComparabletest;

/**
 * @author:whr 2019/7/13
 */
public class Student implements Comparable<Student> {

    private String name;
    private int age;


    @Override
    public int compareTo(Student stu) {
        int flag = this.name.compareTo(stu.name);
        if (flag == 0)
            flag = this.age - stu.age;
        return flag;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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
