package com.zlikun.jee.sort.bubbling;

import com.zlikun.jee.sort.ArrayFactory;

import java.util.Arrays;

/**
 * 冒泡排序，改进第二版：每轮比较中，即使后续元素已有完全有序，也要完成该轮循环（比较），因此有优化空间，<br/>
 * 通过设置一个排序边界，每轮比较过程中更新该边界值，以减少比较次数
 *
 * @author zlikun
 * @date 2019/3/6 19:43
 */
public class BubbleSort4 {

    public static void main(String[] args) {

        // 排序前数组
        // 准备要排序的数组
        int[] array = ArrayFactory.createArray(10);
        // 排序前：[75, 74, 253, 96, 248, 9, 170, 20, 174, 210]
        System.out.println("排序前：" + Arrays.toString(array));

        // 排序后数组
        new BubbleSort4().sort(array);
        // 排序后：[9, 20, 74, 75, 96, 170, 174, 210, 248, 253]
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public void sort(int[] array) {
        // 假设有一个有序边界，默认数组最后一个元素索引（边界之外的元素有序，即：当前没有有序元素）
        int border = array.length - 1;
        // 外层循环用于控制比较轮数：[n - 1]轮
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标志，默认有序，每次交换则变更为无序
            boolean flag = true;
            // 每轮比较最后有序元素索引（边界），经过一轮比较后该边界值被更新
            int lastIndex = -1;
            // 进行每一轮比较，每次确定当前循环最后一位的值（交换，移动）
            for (int j = 0; j < border; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    flag = false;
                    // 如果发生交换，则移动边界
                    lastIndex = j;
                }
            }
            // 更新下一轮边界值
            border = lastIndex;
            // 如果内层一轮比较完成，有序状态未发生变化，则整体有序，不再继续排序
            if (flag) {
                break;
            }
        }
    }

}
