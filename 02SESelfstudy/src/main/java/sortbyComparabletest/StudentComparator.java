package sortbyComparabletest;

import java.util.Comparator;

/**
 * @author:whr 2019/7/13
 */
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}
