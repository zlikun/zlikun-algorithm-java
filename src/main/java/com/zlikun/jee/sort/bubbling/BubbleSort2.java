package com.zlikun.jee.sort.bubbling;

import com.zlikun.jee.sort.ArrayFactory;

import java.util.Arrays;

/**
 * 冒泡排序，实现向前冒泡
 *
 * @author zlikun
 * @date 2019/3/6 19:43
 */
public class BubbleSort2 {

    public static void main(String[] args) {

        // 排序前数组
        // 准备要排序的数组
        int[] array = ArrayFactory.createArray(10);
        // 排序前：[195, 241, 95, 141, 211, 18, 131, 187, 51, 115]
        System.out.println("排序前：" + Arrays.toString(array));

        // 排序后数组
        new BubbleSort2().sort(array);
        // 排序后：[18, 51, 95, 115, 131, 141, 187, 195, 211, 241]
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public void sort(int[] array) {
        // 外层循环用于控制比较轮数：[n - 1]轮
        for (int i = 0; i < array.length - 1; i++) {
            // 进行每一轮比较，每次确定当前循环最后一位的值（交换，移动）
            for (int j = array.length - 1; j > i; j--) {
                // 内层反向循环，小数前移，每次确认最小数
                if (array[j - 1] > array[j]) {
                    int t = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = t;
                }
            }
        }
    }

}
