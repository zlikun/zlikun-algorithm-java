package com.zlikun.jee.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zlikun
 * @date 2019/3/6 19:51
 */
public class ArrayFactory {

    /**
     * 创建n个元素的数组
     *
     * @param n
     * @return
     */
    public static final int[] createArray(int n) {
        // 使用随机数初始化数组
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt() & 0xff;
        }
        return array;
    }

}
