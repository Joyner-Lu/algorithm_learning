package com.joyner.algorithm.mashibing_master.day01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * 给定一个整型数组arr，和一个整数num
 * 某个arr中的子数组sub，如果想达标，必须满足：
 * sub中最大值 – sub中最小值 <= num，
 * 返回arr中达标子数组的数量
 *
 *
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
public class Code02_AllLessNumSubArray {


    /**
     *
     * 子数组sub 从l .. r如果达标，那么必然存在两个如下规律
     * 1.  sub的所有子数组必达标。 因为max(子数组) 一定小于等于max(sub), min(子数组) 大于等于min(sub), 所以必达标
     * 2.  如果一个sub不达标，那么在在怎么扩也不会达标。因为 max(扩) > max(sub), 且 min(扩) <= min(sub),因此必不达标
     *
     * 思路：
     * 1. 以0开头的往右扩，看满足条件的可以扩多远。 然后统计个数
     * 2. 以1开头的往右扩，看满足条件的可以扩多远吗。然后统计个数
     * 3.循环1，和2. 最后累加起来就是要计算的值。
     *
     * 例如：从0到5位置达标，到6位置不达标，那么就统计0到5的达标数量  5 - 0 + 1 = 6
     * 0往后扩一个位置（1到5一定是达标的，根据规律1），继续往下扩
     *
     * 所以整个算法下来的时间复杂度是O(n)
     *
     *
     * @param arr
     * @param num
     * @return
     */
    public static int getNumV2(int[] arr, int num) {
        //从大到小
        Deque<Integer> maxDeque = new LinkedList<>();
        //从小到大
        Deque<Integer> minDeque = new LinkedList<>();
        int result = 0;

        //L从 0 到N -1
        int R = 0;
        for (int L = 0; L < arr.length; L++) {
            //1.i位置进入窗口，检查是否达标
            //2. 如果不达标，收集答案，并且窗口的左侧往右动 L往右动一个位置
            //3.如果达标，继续往右扩
            if (R < L) {
                R = L;
            }
            while (R < arr.length) {
                Integer maxDequeLastIndx = maxDeque.peekLast();
                while (maxDequeLastIndx != null && arr[R] >= arr[maxDequeLastIndx]) {
                    //进来的数大于等于尾部的数，则淘汰尾部的数
                    maxDeque.pollLast();
                    maxDequeLastIndx = maxDeque.peekLast();
                }
                maxDeque.addLast(R);

                Integer minDequeLastIndx = minDeque.peekLast();
                while (minDequeLastIndx != null && arr[R] <= arr[minDequeLastIndx]) {
                    //进来的数小于等于尾部的数，则淘汰尾部的数
                    minDeque.pollLast();
                    minDequeLastIndx = minDeque.peekLast();
                }
                minDeque.addLast(R);


                //检查是否达标
                boolean isT = arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] <= num;
                if (!isT) {
                    break;

                }
                //往右扩
                R++;
            }

            //不达标收集答案
            result += (R - L);

            //淘汰的索引
            int forgetIndx = L;
            if (forgetIndx == maxDeque.peekFirst()) {
                //淘汰
                maxDeque.pollFirst();
            }

            if (forgetIndx == minDeque.peekFirst()) {
                //淘汰
                minDeque.pollFirst();
            }
        }




        return result;
    }



    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 4};
        int num = Integer.MIN_VALUE;
        int num1 = getNumV2(arr, num);
        System.out.println(num1);
    }
}
