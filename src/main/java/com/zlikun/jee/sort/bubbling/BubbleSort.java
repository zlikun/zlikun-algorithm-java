package com.zlikun.jee.sort.bubbling;

import com.zlikun.jee.sort.ArrayFactory;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author zlikun
 * @date 2019/3/6 19:43
 */
public class BubbleSort {

    public static void main(String[] args) {

        // 排序前数组
        // 准备要排序的数组
        int[] array = ArrayFactory.createArray(10);
        // 排序前：[8, 231, 244, 32, 221, 248, 8, 153, 142, 235]
        System.out.println("排序前：" + Arrays.toString(array));

        // 排序后数组
        new BubbleSort().sort(array);
        // 排序后：[8, 8, 32, 142, 153, 221, 231, 235, 244, 248]
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
            for (int j = 0; j < array.length - i - 1; j++) {
                // 大数后移（冒泡，如果希望向前冒，则需要调整内层循环，倒着遍历即可）
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

}
