package com.joyner.algorithm.leetcode_practice;

import com.joyner.common.util.collection.ArrUtils;

import java.util.Arrays;

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
public class MergeSortedArray_two_pointer_88 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //新数组的最后一个数
        int p = m + n - 1;
        //指向nums1的最后一个数
        int p1 = m -1;
        //指向nums2的最后一个数
        int p2 = n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums2[p2] > nums1[p1]) {
                //p2左移
                nums1[p--] = nums2[p2--];
            } else {
                //p1左移
                nums1[p--] = nums1[p1--];
            }
        }
        //补充剩余的数据
        if (p1 > 0) {
            while (p1 >= 0) {
                nums1[p--] = nums1[p1--];
            }
        } else {
            while (p2 >= 0) {
                nums1[p--] = nums2[p2--];
            }
        }


    }

    public static void main(String[] args) {

        int[] ums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {1,5,9};
        int n = 3;
        MergeSortedArray_two_pointer_88 mergeSortedArray_88 = new MergeSortedArray_two_pointer_88();
        mergeSortedArray_88.merge(ums1, m, nums2, n);
        System.out.println();
        ArrUtils.printArr(ums1);
    }

}
