package com.zlikun.jee.sort.shell;

import com.zlikun.jee.sort.ArrayFactory;
import com.zlikun.jee.sort.bubbling.BubbleSort;

import java.util.Arrays;

/**
 * 希尔排序，图例参考下面链接 <br/>
 * https://www.cnblogs.com/chengxiao/p/6104371.html <br/>
 *
 * @author zlikun
 * @date 2019/3/12 18:56
 */
public class ShellSort {

    public static void main(String[] args) {

        // 排序前数组
        // 准备要排序的数组
        int[] array = ArrayFactory.createArray(10);
        // 排序前：[162, 126, 194, 5, 71, 131, 103, 50, 224, 59]
        System.out.println("排序前：" + Arrays.toString(array));

        // 排序后数组
        new ShellSort().sort(array);
        // 排序后：[5, 50, 59, 71, 103, 126, 131, 162, 194, 224]
        System.out.println("排序后：" + Arrays.toString(array));
    }

    public void sort(int[] array) {
        // 取k为间隔长度，每次折半，直到1止（1的这一次需要执行完）
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // 内部实际是插入排序，但间隔调整为k（插入排序间隔为1，每次移动一位），表示将序列分为k组
            // 每轮都尽可能多的移动元素位置（插入排序一次只移动一个），当步长越小时，整个序列越趋于有序
            // 最后一次步长为1，此时只需要少量移动元素即可完成排序
            for (int i = gap; i < array.length; i += gap) {
                int sentinel = array[i];
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (sentinel < array[j]) {
                        array[j + gap] = array[j];
                        array[j] = sentinel;
                    } else {
                        break;
                    }
                }
            }
        }

    }


}
