package com.joyner.algorithm.mashibing_primary.sort;

import com.joyner.common.util.collection.ArrUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 基数排序（桶排序中的一种），针对的时非负的整数。
 * 1.准备10个长度的count数组，count = new count[10]
 * 2.获取数组的最大值计算最大位数，从个位开始
 *   2.1）遍历数组，获取当前位的数，然后count[arr[i]]++（也就是统计词频）
 *   2.2）对count数组进行处理，变成前缀和，此时表示的是，某个位置的值，表示小于等于i的有几个
 *   例如：arr = {402, 401, 403, 33, 55, 32}
 *        个位：count ={0, 1, 2, 2, 0, 1, 0, 0, 0, 0},val表示个位=i的个位
 *        变成前缀和count1 = {0, 1, 3, 5, 5, 6, 6, 6, 6},val表示 <=i的个数
 *   2.3）遍历数组，从右边开始（注意是从右边开始），获取个位，在count1里面查找，例如是2，那么count1的值找到的就是3，
 *   表示小于等于2的有3个，那么其范围必然是0~2,如果是常规的入桶出桶，最右边的数一定是最后倒出的（因为是从左到右入桶），
 *   此时2的位置一定就是该数。count1 对应的位置的值减1，表示<=2的只有2个了
 *   2.4）继续十位、百位...重复上面的过程
 *
 * 备注：要求必须时非负的整数
 *
 * </pre>
 *
 * @author 陆清云 luqy
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class RadixSortV2 {


    public void sort(int[] arr) {
        int maxDigits = maxDigits(arr);
        int[] help = new int[arr.length];
        for (int digit = 1; digit <= maxDigits; digit++) {
            int[] count = new int[10];
            for (int i = 0; i < arr.length; i++) {
                int d = getNumber(arr[i], digit);
                //统计词频
                count[d]++;
            }

            //把count变成前缀和
            for (int i = 1; i < count.length; i++) {
                count[i] = count[i - 1] + count[i];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                int d = getNumber(arr[i], digit);
                //获取前缀和
                int preSum = count[d];
                help[preSum - 1] = arr[i];
                //前缀和减1
                count[d]--;
            }

            //copy
            for (int i = 0; i < arr.length; i++) {
                arr[i] = help[i];
            }
        }

    }

    /**
     * 获取一个数的个位、十位、百位..., no从1开始，1表示拿个位，2表示拿十位...
     *
     * @param val
     * @param no
     * @return
     */
    private int getNumber(int val, int no) {

        int result = val;
        while (no > 0) {
            int reminder = val % 10;
            //覆盖结果
            result = reminder;
            no--;
            //拿商，
            val = val / 10;
        }
        return result;
    }

    private int maxDigits(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        int res = 1;
        while (maxVal / 10 != 0) {
            res++;
            maxVal = (maxVal / 10);
        }
        return res;
    }


    public static void main(String[] args) {
        RadixSortV2 radixSortV1 = new RadixSortV2();
        int[] arr = {33, 2, 55, 21, 9, 11, 30, 888,777, 0};
        radixSortV1.sort(arr);
        ArrUtils.printArr(arr);
    }

}
