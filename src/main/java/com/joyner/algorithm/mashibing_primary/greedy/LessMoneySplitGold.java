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
public class LessMoneySplitGold {

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

    /**
     * 贪心算法
     * 1.准备一个小根堆，把所有数都放到小根堆里面
     * 2.弹出两个数，相加，把相加的结果放入小根堆里面，且把结果累加到结果里面，最后的结果就是答案
     *
     *
     * @param arr
     * @return
     */
    public static int lessMoney2(int[] arr) {
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            smallHeap.add(arr[i]);
        }

        int result = 0;
        while (smallHeap.size() > 1) {
            Integer r1 = smallHeap.poll();
            Integer r2 = smallHeap.poll();
            int r3 = r1 + r2;
            smallHeap.add(r3);
            result += r3;
        }


        return result;
    }

    private static int process(int[] arr, int preMoney) {
        if(arr.length == 1) {
            //返回结果
            return preMoney;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                //当前的两两合并累加上之前所花费的钱
                int newPreMoney = preMoney + arr[i] + arr[j];
                int[] newArr = copyAndMerge(arr, i, j);
                int subMoney = process(newArr, newPreMoney);
                ans = Math.min(ans, subMoney);
            }
        }
        return ans;
    }

    private static int[] copyAndMerge(int[] arr, int i, int j) {
        int[] newArr = new int[arr.length - 1];
        int idx = 0;
        for (int k = 0; k < arr.length; k++) {
            if (k != i && k != j) {
                newArr[idx++] = arr[k];
            }
        }
        //把之前结合的值，给到最后一个
        newArr[idx] = arr[i] + arr[j];
        return newArr;
    }


    public static void main(String[] args) {
        int[] arr = {5,4,1};
        int i = lessMoney2(arr);
        System.out.println(i);

        int i1 = LessMoneySplitGoldTest.lessMoney2(arr);

        System.out.println(i1);
    }



}
