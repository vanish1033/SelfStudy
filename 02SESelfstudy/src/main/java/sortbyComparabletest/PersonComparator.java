package sortbyComparabletest;

import java.util.Comparator;

/**
 * @author:whr 2019/7/14
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
