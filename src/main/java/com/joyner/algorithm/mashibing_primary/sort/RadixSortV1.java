package com.joyner.algorithm.mashibing_primary.sort;

import com.joyner.common.util.collection.ArrUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 基数排序（桶排序中的一种），针对的时非负的整数。
 * 1.准备0~9个桶，队列
 * 2.找出数组的最
 *
 *
 * 1大值，计算位数
 * 3.从个位开始，看个位的数据，如果时0，放入0号桶，1，放入1 号桶，遍历完整个数组之后，从左到右把桶的数据倒出来。（完成个位排序）
 * 4.接下来就是十位的数据，同样如果时0，入0号桶，1入1号桶，从左往右依次倒出（完成十位排序）
 * 5.调整到下一位，重复第4步操作即可。
 *
 * 备注：要求必须时非负的整数
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
public class RadixSortV1 {

    Queue<Integer>[] buckets = new Queue[10];

    public void sort(int[] arr) {
        int maxDigits = maxDigits(arr);
        int no = 1;
        while (maxDigits > 0) {
            for (int i = 0; i < arr.length ; i++) {
                //获取当前位
                int curDigit = getNumber(arr[i], no);

                //入桶
                Queue<Integer> bucket = buckets[curDigit];
                if (bucket == null) {
                    bucket = new LinkedList<>();
                    buckets[curDigit] = bucket;
                }
                bucket.offer(arr[i]);
            }

            //从左到右把桶里面的数据倒出来
            int idx = 0;
            for (int i = 0; i < 10; i++) {
                Queue<Integer> bucket = buckets[i];
                while (bucket != null && !bucket.isEmpty()) {
                    Integer pollVal = bucket.poll();
                    arr[idx++] = pollVal;
                }
            }

            //取下一位
            no++;
            maxDigits--;
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
        RadixSortV1 radixSortV1 = new RadixSortV1();
        int[] arr = {33, 2, 55, 21, 9, 11, 30, 888,777, 0};
        radixSortV1.sort(arr);
        ArrUtils.printArr(arr);
    }

}
