package dontKnow.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.*;
import com.google.common.primitives.Chars;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;


/**
 * @author:whr 2019/11/23
 */
public class Guava {

    @Test
    public void test1() {
        Optional<Object> empty = Optional.empty();
        Optional.of(empty);
//        Optional.of(null);
    }

    /**
     * 不可变集合
     */
    @Test
    public void test2() {
        List<Integer> integers = Lists.newArrayList();
        List<String> strings = Lists.newArrayList();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("1");
        ImmutableSet<String> strings1 = ImmutableSet.copyOf(strings);
        System.out.println(strings1);

        System.out.println("add phone");

//        List<Integer> integers1 = Collections.unmodifiableList(integers);

        ImmutableList<Integer> integers1 = ImmutableList.copyOf(integers);
//        remove1(integers1);

        Set<Integer> integers2 = Sets.newHashSet(1, 1, 1);
        integers2.forEach(System.out::print);
    }

    private void remove1(List<Integer> integers1) {
        integers1.remove(0);
        System.out.println(integers1);
    }

    /**
     * 测试MultiSet
     */
    @Test
    public void test3() {
        HashMultiset<Character> chars = HashMultiset.create();
        Chars.asList("31278351764512847182312".toCharArray())
                .stream()
                .forEach(x -> chars.add(x));
        chars.elementSet().stream().forEach(x -> {
            System.out.println(x + " ------> " + chars.count(x));
        });

        System.out.println("chars.size() = " + chars.size());
        System.out.println("chars.count('2') = " + chars.count((Character) '2'));

        HashMultiset<Object> objects = HashMultiset.create();
        Set<Object> objects1 = objects.elementSet();

        System.out.println("objects1 = " + objects1);

    }

    @Test
    public void test4() {

        HashMultiset<Character> characters = HashMultiset.create();
        Chars.asList("12431252344123125123".toCharArray()).stream().forEach(x -> characters.add(x));
        Set<Character> characters1 = characters.elementSet();
        System.out.println("characters1 = " + characters1);
        Set<Multiset.Entry<Character>> entries = characters.entrySet();
        System.out.println("JSON.toJSONString(entries) = " + JSON.toJSONString(entries));
        System.out.println("entries = " + entries);
    }

}
