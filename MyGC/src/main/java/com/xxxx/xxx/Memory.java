package com.xxxx.xxx;

import lombok.Data;

/**
 * @author:whr 2019/9/9
 */
@Data
public class Memory {

    // 分界点指针
    private int Cutoffpointpointer = 0;

    // 数组模拟内存空间
    private Object[] arr = new Object[1000];

}
