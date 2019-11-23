package test1;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author:whr 2019/10/23
 */
public class test1_3 {

    @Test
    public void test1() {

        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "1", "3", "8", "0", "-1");
        Stream<String> stream = strings.stream();

        stream.sorted(String::compareTo)
                .forEach(System.out::println);

    }

    @Test
    public void test2() throws IllegalAccessException, InvocationTargetException, InstantiationException {

        LocalDate localDate = (LocalDate) LocalDate.class.getConstructors()[0].newInstance(1997, 12, 26);

        System.out.println(localDate);

//        LocalDate localDate = new LocalDate(1997, 12, 26);

    }

}
