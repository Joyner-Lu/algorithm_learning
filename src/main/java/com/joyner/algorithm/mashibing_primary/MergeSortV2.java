package com.joyner.algorithm.mashibing_primary;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 * 归并排序-非递归版本<br>
 *     通过步长来解决。刚开始步长为1，分左group和右group,如果只有左group则不处理
 *     左group和右group两两merge
 * </pre>
 *
 * @author 陆清云 luqy
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class MergeSortV2 {


    public void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int step = 1;

        while (step < arr.length) {

            int curIdx = 0;
            while (curIdx < arr.length) {
                int left = curIdx;
                int middle = left + step - 1;
                if (middle >= arr.length) {
                    break;
                }

               /* int right = middle + step;
                if (right >= arr.length) {
                    right = arr.length - 1;
                }*/
                int right = Math.min(middle + step, arr.length - 1);
                merge(arr, left, middle, right);
                curIdx = right + 1;
            }

            //防止越界
            if (step > arr.length / 2) {
                break;
            }

            //加大步长
            step = step << 1;

        }

    }


    /**
     * left到right位置是排好序的，middle + 1位置到right是排好序的。
     * 该方法的功能是把left到right位置让其排好序。
     *
     * @param arr
     * @param left
     * @param middle
     * @param right
     */
    public void merge(int[] arr, int left, int middle, int right) {
        int[] helper = new int[right - left + 1];
        int p1 = left;
        int p2 = middle + 1;
        int idx = 0;
        while (p1 <= middle && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                helper[idx++] = arr[p1++];
            } else {
                helper[idx++] = arr[p2++];
            }

        }
        while (p1 <= middle) {
            //补充p1
            helper[idx++] = arr[p1++];
        }
        while (p2 <= right) {
            //补充p2
            helper[idx++] = arr[p2++];
        }
        //copy
        for (int i = left; i <= right; i++) {
            arr[i] = helper[i - left];
        }

    }

    public static void main(String[] args) {
        MergeSortV2 mergeSortV2 = new MergeSortV2();
       /* int[] arr = {2, 1, 8, 10, -3, -10, 9};

        mergeSortV2.mergeSort(arr);
        ArrUtils.printArr(arr);*/
        int testTimes = 10000;
        int maxLen = 1000;
        int maxVal = 1000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = RandomGenerator.generateRandomArr(maxLen, maxVal);
            int[] copy = ArrUtils.arrCopy(arr);

            mergeSortV2.mergeSort(arr);
            if (!ArrUtils.isAscSorted(arr)) {
                throw new RuntimeException("fuck you!" + copy);
            }
        }
        System.out.println("ok you got it!!!!!");
    }

}
