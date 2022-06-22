package com.joyner.algorithm.leetcode_practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class ClimbingStairs_70 {

    /**
     * 1.计算最多的2的个数， max2 = n/2;  选择max2个2，分两种情况
     * 有余数，则总数为： 从max2 + 1，选择一个位置的组合数
     * 计算得sum1
     * 2.把2减少一个，也就是max2_new= max2-1,则1新增的个数是：2
     * 则总数为： 从max2_new + 2 + 余数，选择（2 + 余数）的组合
     * 3.继续2的步骤，直到所有的都为1
     *
     * @param n
     * @return
     */

    public int climbStairs(int n) {
        int sum = 0;
        int max2Num = n / 2;//商,最大的2的个数
        int reminder = n % 2;//余数
        int _1nums = -1;//1的个数

        for (int i = max2Num , j = 0; n != 0 && i >= 0 ; i--, j++) {
            if (i == max2Num) {
                if (reminder == 0) {
                    sum += 1;
                } else {
                    sum += nchoosek(max2Num + 1, 1);
                }
            } else if (i == 0) {
                //全为1
                sum += 1;
            } else {
                _1nums = j*2 + reminder;
                sum += nchoosek(i + _1nums, _1nums);
            }
        }
        return sum;
    }

    /**
     * 计算组合数,从n个数中选择m个数的组合数
     *
     * @param n
     * @param m
     * @return
     */
    private int combination(long n, long m) {
        long tempM = m;
        if (n - m < m) {
            //替换C5-3为C5-2,防止乘法溢出
            m = n - m;
        }

        long fz = 1;//分子
        long fm = 1;//分母

        for (long i = n; i > n - m; i--) {
            fz *= i;
        }

        for (long i = 1; i <= m; i++) {
            fm *= i;
        }
        long result = fz / fm;
        if(result < 0) {
            System.out.println("n=" + n + ",m=" + tempM);
        }
        return (int)result;

    }

    public  long nchoosek(int n, int k){
        if(n > 70 || (n == 70 && k > 25 && k < 45)){
            throw new IllegalArgumentException("N(" + n + ") and k(" + k + ") don't meet the requirements.");
        }
        checknk(n, k);
        k = k > (n - k) ? n - k : k;
        if(k <= 1){  // C(n, 0) = 1, C(n, 1) = n
            return k == 0 ? 1 : n;
        }
        HashMap<Integer, Integer> primeMap = new HashMap<>();
        for(int i = n - k + 1; i <= n; i++){
            for(int prime : factor(i)){
                Integer primeCount = primeMap.get(prime);
                primeMap.put(prime, primeCount == null ? 1 : primeCount + 1);
            }
        }
        for(int i = 2; i <= k; i++){
            for(int prime : factor(i)){
                primeMap.put(prime, primeMap.get(prime) - 1);
            }
        }
        long cnk = 1L;
        for(Map.Entry<Integer, Integer> entry : primeMap.entrySet()){
            int coef = entry.getKey();
            int exp = entry.getValue();
            if(exp > 0){
                cnk *= (long) Math.pow(coef, exp);
            }
        }
        return cnk;
    }

    public static int[] factor(int n){
        if(n < 0){
            throw new IllegalArgumentException("N must be a non negative integer.");
        }
        if(n < 4){
            return new int[]{n};
        }
        int factorNums = (int)(Math.log(Integer.highestOneBit(n)) / Math.log(2));
        int[] factors = new int[factorNums];
        int factorCount = 0;
        for(int i = 2; i <= (int) Math.sqrt(n); i++){
            if(n % i == 0){
                factors[factorCount++] = i;
                n /= i;
                i = 1;
            }
        }
        factors[factorCount++] = n;
        return Arrays.copyOf(factors, factorCount);
    }

    public  void checknk(int n, int k){
        if(k < 0 || k > n){ // N must be a positive integer.
            throw new IllegalArgumentException("K must be an integer between 0 and N.");
        }
    }


    public static void main(String[] args) {

        ClimbingStairs_70 climbingStairs_70 = new ClimbingStairs_70();
        int n = climbingStairs_70.climbStairs(44);
        System.out.println(n);


    }
}
