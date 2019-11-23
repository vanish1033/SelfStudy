package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Stream流的方法
 *
 * @author:whr 2019/8/18
 */
public class test1_2 {
    public static void main(String[] args) {
        //2.1去重和过滤
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "aaa", "aaa", "b", "ccc", "d", "eee", "f", "f");
        Stream<String> stream = strings.stream();
        stream.distinct().forEach(s -> System.out.print(s + "  "));
        System.out.println();
        Stream<String> stream1 = strings.stream();
        stream1.distinct().filter(x -> x.length() > 2).forEach(x -> System.out.print(x + "  "));
        System.out.println();

        //2.2排序
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        Stream<Integer> stream2 = integers.stream();
        stream2.sorted(Integer::compareTo).forEach(System.out::print);
        System.out.println();

        //2.3limit截取
        ArrayList<Integer> integers1 = new ArrayList<>();
        Collections.addAll(integers1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        integers1.stream()
                .sorted(Integer::compareTo)
                .limit(5)
                .skip(2)
                .forEach(x -> System.out.print(x + "  "));

    }
}
