package com.joyner.algorithm.mashibing_trainingcamp001.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * <pre>
 * 假设一个固定大小为W的窗口，依次划过arr，
 * 返回每一次滑出状况的最大值
 * 例如，arr = [4,3,5,4,3,3,6,7], W = 3
 * 返回：[5,5,5,4,6,7]
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
public class Code01_SlidingWindowMaxArray {

    public int[] slidingWinMax(int[] arr,int wSize) {

        int[] result = new int[arr.length - wSize + 1];
        int idx = 0;
        SlidingWindowUtil util = new SlidingWindowUtil(arr, wSize);
        util.printSlidingWin();
        Integer maxValOfSlidingWin = util.maxValOfSlidingWin();
        result[idx++] = maxValOfSlidingWin;

        boolean isCanMOve = util.forwardAll();
        util.printSlidingWin();
        while (isCanMOve) {
            maxValOfSlidingWin = util.maxValOfSlidingWin();
            result[idx++] = maxValOfSlidingWin;
            //继续移动
            isCanMOve = util.forwardAll();
            util.printSlidingWin();

        }
        return result;
    }


    public int[] slidingWinMin(int[] arr,int wSize) {

        //List<Integer> result = new ArrayList<>();
        int[] result = new int[arr.length - wSize + 1];
        int idx = 0;
        SlidingWindowUtil util = new SlidingWindowUtil(arr, wSize);
        util.printSlidingWin();
        Integer minValOfSlidingWin = util.minValOfSlidingWin();
        result[idx++] = minValOfSlidingWin;

        boolean isCanMOve = util.forwardAll();
        util.printSlidingWin();
        while (isCanMOve) {
            minValOfSlidingWin = util.minValOfSlidingWin();
            result[idx++] = minValOfSlidingWin;
            //继续移动
            isCanMOve = util.forwardAll();
            util.printSlidingWin();

        }
        return result;
    }

    public int[] toArr(List<Integer> result) {
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private int maxVal(int[] slidWin) {
        int max = Integer.MIN_VALUE;
        for (int i : slidWin) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Code01_SlidingWindowMaxArray slidingWindowMaxArray = new Code01_SlidingWindowMaxArray();
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 1};
        int wSize = 3;
        int[] ints = slidingWindowMaxArray.slidingWinMax(arr, wSize);
        printResult(ints);
        System.out.println("-----------------");
        int[] ints1 = slidingWindowMaxArray.slidingWinMin(arr, wSize);
        printResult(ints1);
        System.out.println("-----------------");



    }

    private static void printResult(int[] result) {
        System.out.print("result：[");
        for (int el : result) {
            System.out.print(el + ",");
        }
        System.out.print("]");

    }
}
