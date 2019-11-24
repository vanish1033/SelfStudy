package dontKnow.guava;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author:whr 2019/11/24
 */
public class OptionalTest {

    @Test
    public void test1() {
        // 创建空的Optional对象
        Optional<Object> optional = Optional.empty();

        // 创建不能为空的Optional对象
        Optional<String> optional1 = Optional.of("汪弘睿");

        // 使用任意值创建Optional对象
        Optional<Object> optional2 = Optional.ofNullable("12");

        // null返回false，非null返回true
        System.out.println("optional.isPresent() = " + optional.isPresent());
        System.out.println("optional1.isPresent() = " + optional1.isPresent());
        System.out.println("optional2.isPresent() = " + optional2.isPresent());
        System.out.println();
//        不为null才执行方法
        optional.ifPresent(System.out::println);
        optional1.ifPresent(System.out::println);
        optional2.ifPresent(System.out::println);

        System.out.println("optional.orElseGet(() -> 1) = " + optional.orElseGet(() -> 1));
        System.out.println("optional.orElseGet(() -> 1) = " + optional.orElse(2));

        System.out.println("=============================================");
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add(null);
        list.stream().filter(Objects::nonNull).forEach(System.out::println);

    }

}
