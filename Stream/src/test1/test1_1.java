package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Stream流的创建
 *
 * @author:whr 2019/8/18
 */
public class test1_1 {
    public static void main(String[] args) {
        //1.1通过list获得Stream流
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "wkcto", "hello", "jj", "dd", "mm", "bjpowernode");
        Stream<String> stream = strings.stream();
        stream.forEach(t -> System.out.print(t + "  "));
        System.out.println();

        //1.2通过数组获得Stream流
        String[] strs = {"1", "2", "3", "4", "5"};
        Stream<String> stream1 = Arrays.stream(strs);
        stream1.forEach(s -> System.out.print(s + "  "));
        System.out.println();

        //1.3通过Stream类获得流
        Stream<String> stream2 = Stream.of("5", "4", "3", "2", "1");
        stream2.forEach(s -> System.out.print(s + "  "));
        System.out.println();

        //1.4无限流
        Stream.iterate(0, x -> x + 3).limit(10).forEach(x -> System.out.print(x + "  "));
        System.out.println();
        Stream.iterate(2, x -> 2 * x).limit(10).forEach(x -> System.out.print(x + "  "));

    }
}
