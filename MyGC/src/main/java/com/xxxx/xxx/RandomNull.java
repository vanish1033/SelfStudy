package com.xxxx.xxx;

import java.util.Random;

/**
 * 用来随机将内存中数据变为null
 *
 * @author:whr 2019/9/9
 */
public class RandomNull {
    public static void setNull(Memory memory) {

        int i = new Random().nextInt(memory.getCutoffpointpointer());

        memory.getArr()[i] = null;

    }
}
