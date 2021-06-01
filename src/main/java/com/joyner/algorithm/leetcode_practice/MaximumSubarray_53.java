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
public class MaximumSubarray_53 {

    //若当前指针所指之前的和小于0，则丢弃当前元素之前的数列
    //TODO 小于0，如果在和后面的相加，两种情况，第一后面的是负数，那就会更小，如果是正数，那么只会把后面的序列降低（因为是减法）
    //TODO 所以小于0，需要进行重新从当前位置开始

    public int maxSubArray(int[] nums) {
        Integer preSum = nums[0];
        int curSum = nums[0];
        int maxSum = nums[0];
        boolean isNeedFixBeginIdx = true;
        int beginIdx = 0;
        //System.out.println("begin idx:" + beginIdx);
        int endIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (preSum < 0) {
                preSum = cur;
                curSum = cur;
                beginIdx = i;
                //System.out.println("begin idx:" + beginIdx);
            } else {
                curSum += cur;
                preSum = curSum;
            }
            //从当前和最大值取最大，例如[-2, -1, -3]
            if (curSum > maxSum) {
                maxSum = curSum;
                endIdx = i;
                //System.out.println("end idx:" + endIdx);
            }
            //maxSum = Math.max(curSum, maxSum);

        }

        if (beginIdx > endIdx) {
            endIdx = beginIdx;
        }

        System.out.println("begin idx:" + beginIdx + ",end idx:" + endIdx);
        System.out.println("begin val:" + nums[beginIdx] + ",end val:" + nums[endIdx]);
        return maxSum;
    }

    public static void main(String[] args) {
        //int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr = {-3, -2, 1, 3, 4, -4};
        MaximumSubarray_53 maximumSubarray_53 = new MaximumSubarray_53();
        int r = maximumSubarray_53.maxSubArray(arr);
        System.out.println(r);
    }
}
