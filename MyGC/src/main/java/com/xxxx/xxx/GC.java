package com.xxxx.xxx;

/**
 * 手动实现垃圾回收器
 *
 * @author:whr 2019/9/9
 */
public class GC {

    public static void stopOtherThread() {

    }


    /**
     * 整理内存的方法
     *
     * @param memory
     */
    public static void GCMemory(Memory memory) {

        // stop the world
        stopOtherThread();

        Object[] arr = memory.getArr();

        int cutoffpointpointer = memory.getCutoffpointpointer();

        int sum = 0;

        int[] iarr = new int[cutoffpointpointer];

        // 记录不为null的对象，在垃圾回收后应该在什么地方
        for (int i = 0; i < cutoffpointpointer; i++) {
            if (arr[i] != null) {
                iarr[sum++] = i;
            }
        }


        for (int i = 0; i < sum; i++) {
            arr[i] = 10;
        }

    }

}
