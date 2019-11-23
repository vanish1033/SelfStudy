package com.xxxx.xxx;

/**
 * @author:whr 2019/9/9
 */
public class ProductionObject {

    public static synchronized void PutObj(Memory memory) {

        int cutoffpointpointer = memory.getCutoffpointpointer();

        // 判断分界点指针的位置
        if (cutoffpointpointer == (memory.getArr().length - 1)) {
            throw new OOMException("内存空间不足！");
        }

        // 还可以分配对象
        Object[] arr = memory.getArr();
        arr[cutoffpointpointer++] = new Object();

    }

}
