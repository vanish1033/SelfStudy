package _02javase;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author:whr 2019/7/24
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        Class<?> stringClass = Class.forName(String.class.getName());
        System.out.println("------------Fields--------------");
        outputFields(stringClass);
        System.out.println("------------Methods--------------");
        outputMethods(stringClass);

    }

    public static void outputMethods(Class c) {
        Method[] cMethods = c.getMethods();
        for (Method cMethod : cMethods) {
            Class<?>[] parameterTypes = cMethod.getParameterTypes();
            System.out.printf(cMethod.getReturnType().getSimpleName() + "  ");
            System.out.printf(cMethod.getName() + "(");
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i < parameterTypes.length - 1) {
                    System.out.print(parameterTypes[i].getSimpleName() + ", ");
                    continue;
                }
                System.out.print(parameterTypes[i].getSimpleName());
            }
            System.out.printf(")");
            System.out.println();
        }
    }

    public static void outputFields(Class c) {
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }
    }
}
