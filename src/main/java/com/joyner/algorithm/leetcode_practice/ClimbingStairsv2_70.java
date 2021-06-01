package com.joyner.algorithm.leetcode_practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class ClimbingStairsv2_70 {


    private Map<Integer, Integer> sumMap = new HashMap<>();


    /**
     * 分析： 1.如果只有1级台阶，那么只有一种爬法
     *       2.如果有2级台阶，则可以先爬一个台阶，在爬一个台阶，或者一次爬2个台阶，总共2个方法
     *       3.如果有3个台阶，则爬2级台阶 +1级台阶之和
     *
     * @param
     * @return
     */

    public int climbStairsv3(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            if (sumMap.get(n-1) != null) {
                return sumMap.get(n-1);
            }
            if (sumMap.get(n-2) != null) {
                return sumMap.get(n-2);
            }
            int sumN1 = climbStairs(n - 1);
            sumMap.put(n - 1, sumN1);
            int sumN2 = climbStairs(n - 2);
            sumMap.put(n - 2, sumN1);

            return sumN1 + sumN2;
        }
    }

    /**
     * 滚动数组实现
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int first = 1;
        int second = 2;

        int third = n;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }





    public static void main(String[] args) {

        ClimbingStairsv2_70 climbingStairs_70 = new ClimbingStairsv2_70();
        int n = climbingStairs_70.climbStairs(2);
        System.out.println(n);


    }
}
