package com.joyner.algorithm.mashibing_primary;

import com.joyner.common.util.collection.ArrUtils;

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
public class InsertSort_06 {

    public void insertSort(int[] arr) {
        //0-0有序，不用处理
        //希望0-1有序，1往前看，比较是否需要交换
        //0-1已经有序，那边处理0-2有序，往前看，比较是否交换
        //一直到0-n
        //0~n


        //类似于玩牌，你抓一张牌，你手上的已经排好序了，那么比较插入即可。
       /* for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }*/

        /**
         * 0~0 完成
         * 0~1
         * 0~2
         * 0~n-1
         */
        int n = arr.length;
        for (int end = 1; end < n; end ++) {
            int newNumIdx = end;
            //左边有数，且当前大于
            while (newNumIdx -1 >= 0 && arr[newNumIdx - 1] > arr[newNumIdx]) {
                int temp = arr[newNumIdx];
                arr[newNumIdx] = arr[newNumIdx - 1];
                arr[newNumIdx - 1] = temp;
                newNumIdx--;
            }
        }
    }

    public static void main(String[] args) {
        int maxLen = 20;
        int maxVal = 100;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            InsertSort_06 insertSort_06 = new InsertSort_06();
            int[] arr = RandomGenerator.generateRandomArr(maxLen, maxVal);
            int[] copy = ArrUtils.arrCopy(arr);
            insertSort_06.insertSort(arr);
            if (!ArrUtils.isAscSorted(arr)) {
                System.out.println("出错了");
                ArrUtils.printArr(copy);
                throw new RuntimeException("算法出错");
            }

        }
        System.out.println("perfect!!!!!");

    }
}
