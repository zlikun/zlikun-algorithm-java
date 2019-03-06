package com.zlikun.jee.sort.bubbling;

import com.zlikun.jee.sort.ArrayFactory;

import java.util.Arrays;

/**
 * 冒泡排序，改进第一版：默认版本中无论列表是否有序，都需要经过相同次比较才能最终确定排序完成，<br/>
 * 改进后，当序列有序后，不再排序，判断依据是当内层一轮比较完成后，并未发生过交换，则整体有序
 *
 * @author zlikun
 * @date 2019/3/6 19:43
 */
public class BubbleSort3 {

    public static void main(String[] args) {

        // 排序前数组
        // 准备要排序的数组
        int[] array = ArrayFactory.createArray(10);
        // 排序前：[32, 180, 95, 71, 15, 80, 58, 191, 127, 70]
        System.out.println("排序前：" + Arrays.toString(array));

        // 排序后数组
        new BubbleSort3().sort(array);
        // 排序后：[15, 32, 58, 70, 71, 80, 95, 127, 180, 191]
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
            // 有序标志，默认有序，每次交换则变更为无序
            boolean flag = true;
            // 进行每一轮比较，每次确定当前循环最后一位的值（交换，移动）
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    flag = false;
                }
            }
            // 如果内层一轮比较完成，有序状态未发生变化，则整体有序，不再继续排序
            if (flag) {
                break;
            }
        }
    }

}
