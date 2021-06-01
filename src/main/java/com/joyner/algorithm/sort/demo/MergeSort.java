package com.joyner.algorithm.sort.demo;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 *
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
public class MergeSort {

    private int[] targetArr;

    public void mergeSort(int[] targetArr) {
        int[] tempArr = new int[targetArr.length];
        internalMergeSort(targetArr, tempArr,0, targetArr.length - 1);
        //copy sorted to targetArr
        targetArr = tempArr;
    }

    private void internalMergeSort(int[] targetArr,int[] tempArr, int left, int right) {
        if (right - left <= 0) {
            return;
        }

        int mid = left + (right - left) / 2;
        internalMergeSort(targetArr, tempArr, left, mid);
        internalMergeSort(targetArr, tempArr,mid + 1, right);
        //对返回的两个区间进行合并
        merge(targetArr,tempArr, left, mid, mid + 1, right);


    }

    /**
     * 使用双指针法
     * @param targetArr
     * @param leftArrStartIdx
     * @param leftArrEndIdx
     * @param rightStartIdx
     * @param rightEndIdx
     */
    private void merge(int[] targetArr, int[] tempArr, int leftArrStartIdx, int leftArrEndIdx, int rightStartIdx, int rightEndIdx) {
        int copyIdxBegin = leftArrStartIdx;
        int copyIdxEnd = rightEndIdx;
        int p = rightEndIdx;
        while (rightEndIdx >= rightStartIdx && leftArrEndIdx >= leftArrStartIdx) {
            if (targetArr[rightEndIdx]  > targetArr[leftArrEndIdx]) {
                tempArr[p--] = targetArr[rightEndIdx--];
            } else {
                tempArr[p--] = targetArr[leftArrEndIdx--];
            }
        }

        //补充剩余的数据
        if (leftArrEndIdx >= leftArrStartIdx) {
            while (leftArrEndIdx >= leftArrStartIdx) {
                tempArr[p--] = targetArr[leftArrEndIdx--];
            }
        } else {
            while (rightEndIdx >= rightStartIdx) {
                tempArr[p--] = targetArr[rightEndIdx--];
            }
        }
        //copy to target
        for (int i = copyIdxBegin; i <= copyIdxEnd ; i++) {
            targetArr[i] = tempArr[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6 ,2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        ArrUtils.printArr(arr);

        double random = Math.random();
    }
}
