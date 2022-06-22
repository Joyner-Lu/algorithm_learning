package com.joyner.algorithm.leetcode_practice;

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
public class MissingNumber_268 {

    public int missingNumber(int[] nums) {

        int nMax = nums.length;
        int nSum = 0;
        for (int n = 0; n <= nMax; n++) {
            //计算0到n的和
            nSum += n;
        }

        int numSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numSum += nums[i];
        }
        return nSum - numSum;

    }

    private boolean existsIn(int n, int[] nums) {
        boolean exists = false;
        for (int i = 0; i < nums.length; i++) {
            if (n == nums[i]) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        MissingNumber_268 missingNumber_268 = new MissingNumber_268();
        int r = missingNumber_268.missingNumber(nums);
        System.out.println(r);
    }
}
