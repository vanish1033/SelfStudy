package dontknow;

import org.junit.Test;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:whr 2019/10/20
 */
public class TestcopyOnWriteArrayList {

    private final CopyOnWriteArrayList<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<String>();

    public static List<String> list = Collections.synchronizedList(new ArrayList<String>());

    static {
        list.add("a");
        list.add("b");
        list.add("c");
    }

    @Test
    public void test() {

        ReentrantLock reentrantLock = new ReentrantLock();


        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();

        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());
        objects.add(new Object());

        System.out.println("objects.size() = " + objects.size());

        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()) {
            iterator.next();
//            java.lang.UnsupportedOperationException
            iterator.remove();
        }
        System.out.println("objects.size() = " + objects.size());

//        ArrayList<Object> list1 = new ArrayList<>();
//
//        while (true) {
//            list1.add(new Object());
//            System.out.println(list1.size());
//            Field elementData = ArrayList.class.getDeclaredField("elementData");
//            elementData.setAccessible(true);
//            Object[] o = (Object[]) elementData.get(list1);
//            System.out.println("o = " + o.length);
//
//        }

//        HashSet<Object> objectSet = new HashSet<>();
//        objectSet.add(null);

        // 抛异常 TreeSet不能放null
//        TreeSet<Object> objectSet1 = new TreeSet<>();
//        objectSet1.add(null);


//        for (int i = 0; i < 1; i++) {
//            Thread thread = new Thread() {
//                @Override
//                public void run() {
//                    ListIterator<String> iterator = list.listIterator();
//                    while (iterator.hasNext()) {
//                        System.out.println(iterator.next());
//                        iterator.add("1");
//                    }
//                }
//            };
//            thread.start();
//        }

    }

    @Test
    public void test1() {
        stringCopyOnWriteArrayList.add("1");
        stringCopyOnWriteArrayList.add("2");
        stringCopyOnWriteArrayList.add("3");
        stringCopyOnWriteArrayList.add("4");
        ListIterator<String> iterator = (ListIterator<String>) stringCopyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
//            iterator.add("k");
            stringCopyOnWriteArrayList.add("k");
        }
    }

}
