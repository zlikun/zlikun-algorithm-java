package com.zlikun.jee.sort.quick;

import com.zlikun.jee.sort.ArrayFactory;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author zlikun
 * @date 2019/3/7 19:09
 */
public class QuickSort {

    public static void main(String[] args) {

        // 排序前数组
        // 准备要排序的数组
        int[] array = ArrayFactory.createArray(10);
        // 排序前：[54, 41, 23, 255, 10, 242, 167, 252, 65, 182]
        System.out.println("排序前：" + Arrays.toString(array));

        // 排序后数组
        new QuickSort().sort(array);
        // 排序后：[10, 23, 41, 54, 65, 167, 182, 242, 252, 255]
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     * 快速排序，其实现思路是在每轮比较中设置一个支点，将比支点小的元素放在支点左右，大支点大的元素放在支点右边，
     * 然后以支点为界，左右分别递归该过程，直到整体有序
     *
     * @param array
     */
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {

        // 当左边界大于等于右边界时，排序结束，所有元素有序
        if (left >= right) {
            return;
        }

        // 设置一个支点，默认取最左端元素，支点左边存放小于该支点的值，支点右边存放大于（含等于）该支点的值
        int pivot = array[left];

        // 初始化低位、高位索引值
        int low = left;
        int high = right;

        // 实现一轮交换，找到大于支点的数据和小于支点的数据交换位置
        while (low < high) {

            // 从右向左遍历，直到找到比支点小的元素（high此时记录该元素索引）
            while (low < high && pivot < array[high]) {
                high--;
            }

            // 将记录到的比支点小的数据赋值给支点位（支点原有元素使用pivot保存）
            array[low] = array[high];

            // 从左向右遍历，直到找到比支点大的元素（含等于情况，low此时记录该元素索引）
            while (low < high && pivot >= array[low]) {
                low++;
            }

            // 高位high索引元素被赋值到支点索引位置上了，所以其自身被空出来，将找到的大于（含等于）支点元素赋值给high位
            array[high] = array[low];
        }

        // 更新支点位置（此时low空出来了，将支点元素赋值于该位置，low即为支点索引）
        array[low] = pivot;

        // 一轮交换过后，以支点为界，分左右两部分，分别以同样算法递归
        // 注意支点本身不参与递归，因为其本身已经有序
        sort(array, left, low - 1);
        sort(array, low + 1, right);

    }

}
