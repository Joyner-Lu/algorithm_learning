package com.joyner.algorithm.mashibing_primary;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 * 冒泡排序
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
public class BubbleSort_05 {

    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~n 冒泡
        //0~n-1 冒泡
        //0~n-2 冒泡
        //一直到0~1
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }*/
        int N = arr.length;
        for (int i = N; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {

        int maxLen = 20;
        int maxVal = 100;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            BubbleSort_05 bubbleSort_05 = new BubbleSort_05();
            int[] arr = RandomGenerator.generateRandomArr(maxLen, maxVal);
            int[] copy = ArrUtils.arrCopy(arr);
            bubbleSort_05.bubbleSort(arr);
            if (!ArrUtils.isAscSorted(arr)) {
                System.out.println("出错了");
                ArrUtils.printArr(copy);
                throw new RuntimeException("算法出错");
            }

        }
        System.out.println("perfect!!!!!");
    }
}
