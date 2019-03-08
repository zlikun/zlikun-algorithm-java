package com.zlikun.jee.sort.insert;

import com.zlikun.jee.sort.ArrayFactory;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author zlikun
 * @date 2019/3/8 9:56
 */
public class InsertSort {


    public static void main(String[] args) {

        // 排序前数组
        // 准备要排序的数组
        int[] array = ArrayFactory.createArray(10);
        // 排序前：[110, 8, 249, 200, 108, 8, 204, 58, 72, 150]
        System.out.println("排序前：" + Arrays.toString(array));

        // 排序后数组
        new InsertSort().sort(array);
        // 排序后：[8, 8, 58, 72, 108, 110, 150, 200, 204, 249]
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public void sort(int[] array) {
        // 将数组第一个元素视作一个有序序列，将后面的无序列表元素，依次插入到有序序列中
        for (int i = 1; i < array.length; i++) {
            // 取无序序列的第一个元素作为哨兵，遍历有序列表，将其插入正确位置
            int sentinel = array[i];
            // 倒着遍历，因为涉及到元素移动（小的元素向左移）
            for (int j = i - 1; j >= 0; j--) {
                // 如果哨兵比比较数小，则当前元素向后移（可能会移动到哨兵位置，哨兵占据比较数的位置）
                if (sentinel < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = sentinel;
                } else {
                    // 如果不小于比较数，说明哨兵本身有序
                    break;
                }
            }
        }
    }


}
