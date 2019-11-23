package unmodifiableCollectiontest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:whr 2019/7/13
 */
public class Test3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //返回一个只读的list集合
        List<Integer> unmodifiableList = Collections.unmodifiableList(list);
//        试图修改只读list集合会抛出：java.lang.UnsupportedOperationException
//        unmodifiableList.remove((Integer) 2);
        for (int i : unmodifiableList) {
            System.out.print(i + " ");
        }
    }
}
