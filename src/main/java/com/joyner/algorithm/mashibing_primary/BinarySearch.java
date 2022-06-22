package com.joyner.algorithm.mashibing_primary;

import com.joyner.common.util.collection.ArrUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *
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
public class BinarySearch {

    /**
     * 二分查找，返回下标索引
     * @param arr
     * @param num
     * @return
     */
    public boolean find(int[] arr, int num) {
        boolean ans = false;
        int left = 0;
        int len = arr.length;
        int right = len - 1;
        while (left <= right) {
            //使用加。当left在右边的时候
            int newLen = left + right;
            int mid = newLen / 2;
            if (arr[mid] == num) {
                ans = true;
                break;
            }
            if(num < arr[mid]) {
                //数在左边
                right = mid - 1;
            } else {
                //数在右边
                left = mid + 1;
            }
        }
        return ans;
    }

    @Test
    public void testFind() {
        int[] arr = {21, 7 , 22, 36, 1, 5};
        Arrays.sort(arr);
        boolean b = find(arr, 5);
        System.out.println(b);
    }

    @Test
    public void testMostLeftNoLessNumIndex() {
        int[] arr = {1, 2, 2, 4, 6, 9};
        int i = mostLeftNoLessNumIndex(arr, 2);
        System.out.println(i + ":" + (i < 0 ? "-1" : arr[i]));
    }

    /**
     * 有序数组，找满足>=value的最左位置
     * 同样使用二分查找。
     *
     * [1, 2, 2, 2, 3, 4, 9] 查找2返回的索引是：1
     *
     * [1, 2, 3, 4, 6, 9] 查找5返回的索引是：4 --值是6
     * [1, 2, 3, 4]查找-1，返回0，只是1
     * @param arr
     * @param num
     * @return
     */
    public int mostLeftNoLessNumIndex(int[] arr, int num) {
        int idx = -1;
        int left = 0;
        int len = arr.length;
        int right = len - 1;
        while (left <= right) {
            //使用加。当left在右边的时候
            int newLen = left + right;
            int mid = newLen / 2;
            if (arr[mid] == num) {
                //更新
                idx = mid;
                //继续在左边找
                right = mid - 1;
                continue;
            }
            if(num < arr[mid]) {
                //数在左边
                //更新
                idx = mid;
                right = mid - 1;
            } else {
                //数在右边
                left = mid + 1;
            }
        }
        return idx;

    }

    @Test
    public void testMostRightLessNumIndex() {
        int[] arr = {1, 2, 3, 4, 6, 9};
        int i = mostRightLessNumIndex(arr, 5);
        System.out.println("IDX-" + i + ":VAL-" + (i < 0 ? "-1" : arr[i]));
    }



    /**
     * 有序数组，找满足<=value的最右位置
     * 同样使用二分查找。
     *
     * [1, 2, 2, 2, 3, 4, 9] 查找2返回的索引是：3
     *
     * [1, 2, 3, 4, 6, 9] 查找5返回的索引是：3 --值是4
     * @param arr
     * @param num
     * @return
     */
    public int mostRightLessNumIndex(int[] arr, int num) {
        int idx = -1;
        int left = 0;
        int len = arr.length;
        int right = len - 1;
        while (left <= right) {
            //使用加。当left在右边的时候
            int newLen = left + right;
            int mid = newLen / 2;
            if (arr[mid] == num) {
                //更新
                idx = mid;
                //继续在右边找
                left = mid + 1;
                continue;
            }
            if(num < arr[mid]) {
                //数在左边
                right = mid - 1;
            } else {
                //更新
                idx = mid;
                //数在右边
                left = mid + 1;
            }
        }
        return idx;

    }






    //for test
    public boolean test(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();


       /* int[] arr = {0, 1, 3, 4, 8};
        boolean r = binarySearch.find(arr, -1);
        System.out.println(r);*/


        InsertSort_06 insertSort_06 = new InsertSort_06();

        int maxLen=10;
        int maxVal = 50;
        int num = (int)(Math.random()*maxVal);
        int testTimes = 50000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = RandomGenerator.generateRandomArr(maxLen, maxVal);
            insertSort_06.insertSort(arr);
            if (binarySearch.find(arr, num) != binarySearch.test(arr, num)) {
                System.out.println("fuck....出错了");
                ArrUtils.printArr(arr);
                throw new RuntimeException("算法出错了。给我死回来");
            }

        }
        System.out.println("perfect done!!!!");

    }
}
