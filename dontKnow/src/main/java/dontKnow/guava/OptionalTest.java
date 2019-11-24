package dontKnow.guava;

import java.util.Optional;

/**
 * @author:whr 2019/11/24
 */
public class TestOptional {

    public static void main(String[] args) {
        Optional<Object> o = Optional.ofNullable(new Object());
        boolean present = o.isPresent();
        System.out.println(present);

    }

}
