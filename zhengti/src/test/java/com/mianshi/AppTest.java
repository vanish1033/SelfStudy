package com.mianshi;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.*;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test1() {
//        Single instance1 = Single.getInstance();
//        Single instance2 = Single.getInstance();
//        Single instance3 = Single.getInstance();
//        System.out.println(instance1);
//        System.out.println(instance2);
//        System.out.println(instance3);

        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i <= 100; i++) {
            list.push(i + "");
        }
        System.out.println(list);
        list.pop();
        System.out.println(list);
        List<String> syList = Collections.synchronizedList(list);
    }

    @Test
    public void test2() throws RuntimeException {
        TreeSet<Integer> treeSet = new TreeSet<>(Integer::compare);
        for (int i = 100; i > 0; i--) {
            treeSet.add(i);
        }
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(1);
        System.out.println(treeSet);
    }

    public void test3() {
        test2();
    }

    @Test // 简单测试一下冒泡排序
    public void test4() {
        int[] arr = {5, 4, 7, 0, 9, 8, 1, 3, 2, 34, 55, 8, 7};
//        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int i1 = arr[j];
                int i2 = arr[j + 1];
                if (i1 > i2) {
                    arr[j + 1] = i1;
                    arr[j] = i2;
                }
            }
        }
        for (int a : arr) {
            System.out.print(a + "-");
        }

    }

    @Test
    public void test5() {
        String str = "It's a dog!";
        String[] arrStr = str.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = arrStr.length - 1; i >= 0; i--) {
            sb.append(arrStr[i] + " ");
        }
        System.out.println(sb);
    }

    @Test
    public void test6() {
        ArrayList<Object> objects = new ArrayList<>();
        List<Object> syObjects1 = Collections.synchronizedList(objects);
    }

    @Test
    public void test7() {
        int[] arr = {3, 4, 2, 5, 7, 5, 6, 4, 3, 8, 5, 2, 9, 45, 3, 7, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int ii = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = ii;
                }
            }
        }
        Arrays.stream(arr).forEach((i) -> {
            System.out.print(i + "  ");
        });

    }

    @Test
    public void test8() {
        int flag = 0;
        String str = "sabcasdasabcdasdabcsadasssabc";
        String[] abcs = str.split("abc");
        for (String s : abcs) {
            System.out.print(s + "  ");
        }
        flag = abcs.length - 1;
        if (str.endsWith("abc")) {
            flag += 1;
        }
        System.out.println(flag);
    }

}
