package sortbyComparabletest;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author:whr 2019/7/14
 */
public class TestPerson {
    public static void main(String[] args) {
        Person ms = new Person("苗森", 34);
        Person gjn = new Person("高俊楠", 22);
        Person wkx = new Person("王奎鑫", 24);
        Person zp = new Person("张彭", 21);

        ArrayList<Person> list = new ArrayList<>();
        list.add(ms);
        list.add(gjn);
        list.add(wkx);
        list.add(zp);
//排序前
        for (Person p : list) {
            System.out.print(p + " , ");
        }
        System.out.println();
        Collections.sort(list);
//排序后
        for (Person p : list) {
            System.out.print(p + " , ");
        }

    }
}
