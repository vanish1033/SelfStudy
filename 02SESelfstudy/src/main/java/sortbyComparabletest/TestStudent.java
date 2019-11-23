package sortbyComparabletest;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author:whr 2019/7/13
 */
public class TestStudent {
    public static void main(String[] args) {
        Student ms = new Student("苗森", 77);
        Student gjn = new Student("高俊楠", 23);
        Student wkx = new Student("王奎鑫", 24);
        Student zp = new Student("张彭", 25);
        ArrayList<Student> students = new ArrayList<>();
        students.add(ms);
        students.add(gjn);
        students.add(wkx);
        students.add(zp);

        //原始顺序输出
        for (Student stu : students) {
            System.out.print(stu + "  ");
        }
        System.out.println();


        //通过Comparable接口进行比较,先按名字排，再按年龄排
        Collections.sort(students);
        for (Student stu : students) {
            System.out.print(stu + "  ");
        }
        System.out.println();


        //通过Comparator比较器比较，按年龄比较
        Collections.sort(students, new StudentComparator());
        for (Student stu : students) {
            System.out.print(stu + "  ");
        }
    }
}
