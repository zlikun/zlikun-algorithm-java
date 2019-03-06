package com.zlikun.jee.sort.bubbling;

import com.zlikun.jee.sort.ArrayFactory;

import java.util.Arrays;

/**
 * 冒泡排序，改进第三版：鸡尾酒排序，两边同时冒泡，小的向左，大的向右，减少整体比较轮数
 *
 * @author zlikun
 * @date 2019/3/6 19:43
 */
public class BubbleSort5 {

    public static void main(String[] args) {

        // 排序前数组
        // 准备要排序的数组
        int[] array = ArrayFactory.createArray(10);
        // 排序前：[4, 241, 126, 148, 251, 86, 49, 197, 14, 71]
        System.out.println("排序前：" + Arrays.toString(array));

        // 排序后数组
        new BubbleSort5().sort(array);
        // 排序后：[4, 14, 49, 71, 86, 126, 148, 197, 241, 251]
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public void sort(int[] array) {
        int left = 0;                   // 左边界
        int right = array.length - 1;   // 右边界

        // 使用两个边界进行比较，所以无法控制轮数（但一定少于等于 n / 2 轮）
        while (left < right) {

            // 向左冒泡（从右边界向左端移动）
            for (int j = right; j > left; j--) {
                if (array[j - 1] > array[j]) {
                    int t = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = t;
                }
            }
            // 一轮移动完成后，最小数排在第一位，因此第一位已有序，左边界向右移动一位
            left++;

            // 向右冒泡（从左边界向右端移动）
            for (int j = left; j < right; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
            // 一轮移动完成后，最大数排在最后一位，因此最后一位已有序，右边界向左移动一位
            right--;
        }
    }

}
