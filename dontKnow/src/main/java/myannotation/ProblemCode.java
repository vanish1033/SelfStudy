package myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 保留在源码阶段
 * 可加在方法上和局部变量上
 * 表示该方法有问题
 */
@Target({ElementType.METHOD,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface ProblemCode {
    String value();
}
