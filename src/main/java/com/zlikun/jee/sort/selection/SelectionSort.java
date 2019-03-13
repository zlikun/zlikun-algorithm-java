package com.zlikun.jee.sort.selection;

import com.zlikun.jee.sort.ArrayFactory;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author zlikun
 * @date 2019/3/13 8:57
 */
public class SelectionSort {

    public static void main(String[] args) {

        // 排序前数组
        // 准备要排序的数组
        int[] array = ArrayFactory.createArray(10);
        // 排序前：[69, 102, 133, 49, 217, 175, 214, 75, 117, 42]
        System.out.println("排序前：" + Arrays.toString(array));

        // 排序后数组
        new SelectionSort().sort(array);
        // 排序后：[42, 49, 69, 75, 102, 117, 133, 175, 214, 217]
        System.out.println("排序后：" + Arrays.toString(array));
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 内层循环找出子序列中（以i为界，其后所有元素）最小索引
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int t = array[i];
                array[i] = array[minIndex];
                array[minIndex] = t;
            }
        }

    }

}
