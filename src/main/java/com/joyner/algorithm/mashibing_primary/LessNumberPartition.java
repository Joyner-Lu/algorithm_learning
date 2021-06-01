package com.joyner.algorithm.mashibing_primary;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
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
public class LessNumberPartition {

    /**
     * 给定一个数组，把小于等于num的数挪到左边，大于数放右边<br>
     *     指定小于等于区，初始位置为-1，如果arr[i] <= num, arr[i]和小于等于区的右边第一个数交换，
     *     小于等于区，往后诺一个位置。
     *
     * @param arr
     * @param num
     */
    public void partition(int[] arr, int num) {
        int lessAreaIndx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                ArrUtils.swap(arr, i, ++lessAreaIndx);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 8, 7, 9, 1};
        LessNumberPartition lessNumberPartition = new LessNumberPartition();
        lessNumberPartition.partition(arr, 7);
        ArrUtils.printArr(arr);
    }

}
