package com.joyner.algorithm.mashibing_primary.greedy;

import java.util.PriorityQueue;

/**
 * <pre>
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。
 * 比如长度为20的金条，不管怎么切，都要花费20个铜板。 一群人想整分整块金条，怎么分最省铜板?
 *
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为60，金条要分成10，20，30三个部分。
 *
 * 如果先把长度60的金条分成10和50，花费60; 再把长度50的金条分成20和30，花费50;一共花费110铜板。
 * 但如果先把长度60的金条分成30和30，花费60;再把长度30金条分成10和20， 花费30;一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class LessMoneySplitGoldV2 {

    /**
     * 暴力解，穷举。
     *
     * 思路：两两做合并，之后形成新的数组，然后去递归。如此往复。
     *
     * @param arr
     * @return
     */
    public static int lessMoney1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int result = process(arr, 0);
        return result;
    }



    private static int process(int[] arr, int preMoney) {
        if (arr.length == 1) {
            return preMoney;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int[] newArr = copyAndMerge(arr, i, j);
                int r = process(newArr, preMoney + arr[i] + arr[j]);
                result = Math.min(result, r);
            }
        }
        return result;

    }

    private static int[] copyAndMerge(int[] arr, int i, int j) {
        int[] newArr = new int[arr.length -1];
        int idx = 0;
        for (int k = 0; k < arr.length; k++) {
            if (k != i && k != j) {
                newArr[idx++] = arr[k];
            }
        }
        newArr[idx] = (arr[i] + arr[j]);
        return newArr;
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int i = LessMoneySplitGoldV2.lessMoney1(arr);
        System.out.println(i);
    }



}
