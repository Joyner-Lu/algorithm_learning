package com.joyner.algorithm.sort.demo;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 * 将数据分为已排序区，和未排序区，初始化值，已排序区为第一个元素。
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class InsertSort {

    public void insertSortV1(int[] targetArr) {
        int unSortedIndx = 1;
        for (int i = 0; i < targetArr.length && unSortedIndx < targetArr.length; i++) {
            int unSortedVal = targetArr[unSortedIndx];
            for (int j = i; j >= 0; j--) {
                if (unSortedVal < targetArr[j]) {
                    //在已经拍好序的数组中找位置插入
                    int temp = targetArr[j + 1];
                    targetArr[j + 1] = targetArr[j];
                    targetArr[j] = temp;
                } else {
                    break;
                }
            }
            unSortedIndx++;

        }
    }

    public void insertSortV2(int[] targetArr) {
        //TODO 插入可以使用二分法进行插入，变种
        //TODO 或者取元素的时候取两个，成对插入
        //TODO 插入排序的变种，希尔排序
        for (int i = 1; i < targetArr.length; i++) {
            //待插入元素
            int unsortedVal = targetArr[i];
            //已经排好序的数组的最大索引
            int j = i - 1;
            for (; j >= 0; j--) {
                if (targetArr[j] > unsortedVal) {
                    //交换
                    targetArr[j + 1] = targetArr[j];
                } else {
                    //插入

                    break;
                }
            }
            targetArr[j + 1] = unsortedVal;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSortV2(arr);
        ArrUtils.printArr(arr);

        System.out.println(minRunLength(37));
    }

    private static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;      // Becomes 1 if any 1 bits are shifted off
        while (n >= 32) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
}
