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
public class BestTimeToBuyAndSellStock_121 {

    public int maxProfit(int[] prices) {

        int lowest = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            int currentMax = prices[i] - lowest;
            if (currentMax > maxProfit) {
                maxProfit = currentMax;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        //int[] arr = {2,1,2,0,1};
        BestTimeToBuyAndSellStock_121 sellStock_121 = new BestTimeToBuyAndSellStock_121();
        int d = sellStock_121.maxProfit(arr);
        System.out.println(d);
    }
}
