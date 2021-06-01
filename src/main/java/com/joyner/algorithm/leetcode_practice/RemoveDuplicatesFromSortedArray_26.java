package com.joyner.algorithm.leetcode_practice;

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
public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicatesv1(int[] nums) {
        Integer temp = null;
        int newLen = nums.length;
        //找到第一次重复元素位置指针即可
        int firstRepeatIdx = -1;
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (temp != null && nums[i] == temp) {
                newLen--;
                if (flag) {
                    flag = false;
                    firstRepeatIdx = i;
                }
            } else {
                temp = nums[i];
                if (firstRepeatIdx > 0) {
                    //如果有第一个重复的，那么交换即可
                    nums[firstRepeatIdx++] = nums[i];
                }
            }
        }
        return newLen;
    }

    public int removeDuplicates(int[] nums) {
        int slowIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[slowIdx] != nums[i]) {
                slowIdx++;
                nums[slowIdx]  = nums[i];
            }
        }
        return slowIdx + 1;
    }


    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray_26 removeDuplicatesFromSortedArray_26 = new RemoveDuplicatesFromSortedArray_26();
        int result = removeDuplicatesFromSortedArray_26.removeDuplicates(arr);
        System.out.println(result);
    }

}
