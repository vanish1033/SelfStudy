package removearraylisttest;

import java.util.*;

/**
 * 用迭代器遍历删除ArrayList
 *
 * @author:whr 2019/7/13
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1, 2);
/*        for (int i : arrayList) {
            System.out.print(i + "  ");
        }
        System.out.println();
        ListIterator<Integer> iterator = arrayList.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }*/

        final Iterator<Integer> iterator = arrayList.iterator();
        System.out.println("iterator遍历：");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
        System.out.println();
        System.out.println("增强for遍历：");
        for (int i : arrayList) {
            System.out.print(i + "  ");
        }
        System.out.println();

        ListIterator<Integer> listIterator = arrayList.listIterator();
        System.out.println("listIterator遍历：");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "  ");
        }
        List<Integer> synchronizedList = Collections.synchronizedList(arrayList);

    }
}
