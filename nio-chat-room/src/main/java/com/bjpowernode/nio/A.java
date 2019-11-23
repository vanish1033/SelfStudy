package com.bjpowernode.nio;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @author:whr 2019/11/9
 */
@Data
public class A {


    private int a;

    private int b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a1 = (A) o;
        return a == a1.a &&
                b == a1.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
