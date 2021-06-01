package com.joyner.algorithm.mashibing_primary.sort;

import com.joyner.algorithm.mashibing_primary.RandomGenerator;
import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 * 堆排序
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
public class HeapSort {

    private int heapSize = 0;

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //1.先把数组变成大根堆
        //N*O(N)
        /*for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }*/


        //以下为优化的代码 O(N)
        heapSize = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i);
        }

        //2.把数组的第一个数和最后一个数交换，然后heapSize--,做heapify,也就是堆化
        //直到heapSize变为零
        ArrUtils.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            //堆化
            heapify(arr, 0);
            ArrUtils.swap(arr, 0, --heapSize);
        }

    }

    private void heapify(int[] arr, int curIdx) {
        int leftIdx = 2 * curIdx + 1;
        if (leftIdx >= heapSize) {
            //没有左孩子，哪绝对没有右孩子
            return;
        }
        int rightIdx = leftIdx + 1;
        //左右孩子pk拿到最大索引
        int largestIdx = (rightIdx < heapSize && arr[rightIdx] > arr[leftIdx] ? rightIdx : leftIdx);
        //当前位置和largestIdx进行pk
        while (arr[largestIdx] > arr[curIdx]) {
            ArrUtils.swap(arr, largestIdx, curIdx);
            //把当前位置移动到largestIdx
            curIdx = largestIdx;

            //重新计算左右孩子
            leftIdx = 2 * curIdx + 1;
            if (leftIdx >= heapSize) {
                //没有左孩子，哪绝对没有右孩子
                return;
            }
            rightIdx = leftIdx + 1;
            //左右孩子pk拿到最大索引
            largestIdx = (rightIdx < heapSize && arr[rightIdx] > arr[leftIdx] ? rightIdx : leftIdx);

        }
    }

    private void heapInsert(int[] arr, int curIdx) {
        //1.把当前数放在堆的最后一个位置
        arr[heapSize++] = arr[curIdx];

        //2.往上看,如果我的值大于父亲，则交换，如此往复
        int pIdx = (curIdx - 1) / 2;
        while (curIdx > 0) {
            if (arr[curIdx] > arr[pIdx]) {
                ArrUtils.swap(arr, pIdx, curIdx);
                //继续找父亲
                curIdx = pIdx;
                pIdx = (curIdx - 1) / 2;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

       /* int[] arr = {-704,-660,346,331,267,71,-188};
        heapSort.sort(arr);*/
        int testTimes = 100000;
        int maxLen = 500;
        int maxVal = 1000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = RandomGenerator.generateRandomArr(maxLen, maxVal);
            int[] copy = ArrUtils.arrCopy(arr);
            heapSort.sort(arr);
            if (!ArrUtils.isAscSorted(arr)) {
                ArrUtils.printArr(copy);
                System.out.println("------------after");
                ArrUtils.printArr(arr);
                throw new RuntimeException("fuck you bitch!");
            }
        }
        System.out.println("nice!");
    }
}
