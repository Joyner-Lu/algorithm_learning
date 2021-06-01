package com.joyner.algorithm.mashibing_primary;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class MergeSort {


    public void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        mergeSortHelp(arr, left, right);

    }


    private void mergeSortHelp(int[] arr, int left, int right) {

        if (left == right) {
            return;
        }
        int middle = left + ((right - left) >> 1);
        mergeSortHelp(arr, left, middle);
        mergeSortHelp(arr, middle + 1, right);

        merge(arr, left, middle, right);

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
        int[] arr = {4,1, 5,2};
        MergeSort mergeSort = new MergeSort();
        //mergeSort.merge(arr, 1, 2, 4);
        mergeSort.mergeSort(arr);
        ArrUtils.printArr(arr);

        int l = 1;
        int r = arr.length;

        int m = (l + r) / 2;//其实等同于  (r-l)/2 + l--也就是先按从0的下标开始算，然后在补l的差距
        int s = l + (r - l) >> 1;

        System.out.println(m);
        System.out.println(s);

    }

}
