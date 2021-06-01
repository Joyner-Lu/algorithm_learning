package com.joyner.algorithm.leetcode_practice;

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
public class MergeSortedArray_88 {


    public void mergev2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int newLen = m;
        for (int idx1 = 0; idx1 < m; idx1++) {

            if (nums1[idx1] > nums2[0]) {
                //小于则先交换到，第二个数组的第0个元素
                int temp = nums1[idx1];
                nums1[idx1] = nums2[0];
                nums2[0] = temp;
                //处理第二个数组
                for (int i = 0; i < n - 1; i++) {
                    if (nums2[i] > nums2[i+1]) {
                        //交换
                        int temp1 = nums2[i];
                        nums2[i] = nums2[i+1];
                        nums2[i+1] = temp1;
                    }
                }


            }
        }
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];//
        }


    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArr = new int[m+n];
        int idx1 = 0;
        int idx2 = 0;
        int newIdx = 0;
        while (idx1 < m || idx2 < n) {
            if (idx2 < n && idx1 == m) {
                newArr[newIdx] = nums2[idx2];
                idx2++;
            }
            else if (idx1 < m && idx2 == n) {
                newArr[newIdx] = nums1[idx1];
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]) {
                newArr[newIdx] = nums2[idx2];
                idx2++;
            } else {
                newArr[newIdx] = nums1[idx1];
                idx1++;
            }
            newIdx++;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = newArr[i];
        }
    }


    public void mergev1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < m+n; i++,j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }


    public static void main(String[] args) {

        int[] ums1 = {1,2,8,0,0,0};
        int m = 3;
        int[] nums2 = {1,5,9};
        int n = 3;
        MergeSortedArray_88 mergeSortedArray_88 = new MergeSortedArray_88();
        mergeSortedArray_88.merge(ums1, m, nums2, n);
        System.out.println();
    }

}
