package com.joyner.algorithm.mashibing_primary;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 *
 *【题目】定义局部最小的概念。
 *      arr长度为1时，arr[0]是局部最小。
 *      arr的长度为N(N>1)时，如果arr[0]< arr[1]，那么arr[0]是局部最小；
 *      如果arr[N-1]< arr[N-2]，那么arr[N-1]是局部最小；
 *      如果0< i< N-1，既有arr[i]< arr[i-1]又有arr[i]< arr[i+1]，那么arr[i]是局部最小。
 *
 *      给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 *
 * 【分析】
 *      1.如果第1个和最后一个不是局部最小，也就是刚开始下降的，最后是上升的。那么在[1,N-2]必然存在局部最小。
 *      2.使用二分找到中间位置，如果不是局部最小，那边从1的描述可以得知，要么右边出现局部最小或者左边出现局部最小。依次类推
 *
 *      备注：已知arr中任意两个相邻的数都不相等
 * </pre>
 *
 * @author 陆清云 luqingyun@joyner.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class LocalMinimumValByBinarySearch {

    public int findLocalMinimumVal(int[] arr) {

        int idx = -1;
        if (arr == null || arr.length == 0) {
            return idx;
        }
        int len = arr.length;

        //arr长度为1时，arr[0]是局部最小。
        if (len == 1) {
            return 0;
        }
        //arr的长度为N(N>1)时，如果arr[0]< arr[1]，那么arr[0]是局部最小；
        if (arr[0] < arr[1]) {
            return 0;
        }

        //如果arr[N-1]< arr[N-2]，那么arr[N-1]是局部最小；
        if (arr[len - 1] < arr[len - 2]) {
            return len - 1;
        }
        //L从1开始，R从len - 2开始，因为第一个数和最后一个数不满足。在之前的逻辑已经做过处理。
        int left = 1;
        int right = len - 2;
        //如果0< i< N-1，既有arr[i]< arr[i-1]又有arr[i]< arr[i+1]，那么arr[i]是局部最小。
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                //找到了局部最小值
                idx = mid;
                break;
            } else {
                if (arr[mid] > arr[mid + 1]) {
                    //往右找
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return idx;


    }

    public boolean isLocalMinimum(int[] arr, int idx) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        boolean lessThanLeft = idx > 0 ? arr[idx] < arr[idx - 1] : true;
        boolean lessThanRight = idx < arr.length - 1 ? arr[idx] < arr[idx + 1] : true;

        return lessThanLeft && lessThanRight;
    }


    public int[] generateRandomArr(int maxLen, int maxVal) {
        int len = (int)(Math.random() * maxLen);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = -1;
            do {
                temp = (int)(Math.random() * maxVal);
            } while (i > 0 && temp == arr[i - 1]);
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        LocalMinimumValByBinarySearch minimumValByBinarySearch = new LocalMinimumValByBinarySearch();
     /*   int maxLen = 20;
        int maxVal = 50;

        int[] ints = minimumValByBinarySearch.generateRandomArr(maxLen, maxVal);
        ArrUtils.printArr(ints);*/
        int maxLen = 20;
        int maxVal = 50;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr =  minimumValByBinarySearch.generateRandomArr(maxLen, maxVal);
            ///int[] arr = {21,7,22,36,1,5};
            try {
                int idx = minimumValByBinarySearch.findLocalMinimumVal(arr);
                boolean r = minimumValByBinarySearch.isLocalMinimum(arr, idx);
                if (!r) {
                    ArrUtils.printArr(arr);
                    throw new RuntimeException("fuck you.");
                }
            } catch (Exception ex) {
                ArrUtils.printArr(arr);
                throw new RuntimeException("fuck you.====");
            }


        }
        System.out.println("perfect done!");



    }
}
