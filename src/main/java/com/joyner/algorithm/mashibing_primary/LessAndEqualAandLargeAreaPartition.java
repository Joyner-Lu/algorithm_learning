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
public class LessAndEqualAandLargeAreaPartition {

    /**
     * 给定一个数组，从l到r的范围内把小于num的数挪到左边，大于数放右边,等于的放中间，返回等于的左边界和右边界<br>
     *      指定数在小于区，当前位置和小于区的下一个位置交换，i++,且小于区往下挪一个位置
     *      指定数在等于区，i++
     *      指定数在大于区，当前位置和大于区的下一个位置交换，大于区挪一个位置，i不动
     *      如果 i == 和大于区碰上了，停止，最后把最右边的数和当前的交换，返回结果
     *
     *      备注：小于区初始位于 L -1 ， 大于区初始位于r
     *
     *
     * @param arr
     */
    public int[] partition(int[] arr, int l, int r) {
        int lessIdx = l - 1;
        int moreIdx = r;
        int currIdx = l;
        while (currIdx < moreIdx) {
            int targetVal = arr[r];
            int currVal = arr[currIdx];
            if (currVal < targetVal) {
                //当前位置和小于区的下一个位置交换，i++,且小于区往下挪一个位置
                ArrUtils.swap(arr, currIdx++, ++lessIdx);
            } else if (currVal > targetVal) {
                //指定数在大于区，当前位置和大于区的下一个位置交换，大于区挪一个位置，i不动
                ArrUtils.swap(arr, currIdx, --moreIdx);
            } else {
                //指定数在等于区，i++
                currIdx++;
            }
        }
        //最后把最右边的数和当前的交换
        ArrUtils.swap(arr, currIdx, r);
        int[] result = new int[]{lessIdx+1, moreIdx};
        return result;

    }


    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 8, 7, 9, 8};
                   //0  1  2  3  4  5  6
        LessAndEqualAandLargeAreaPartition lessNumberPartition = new LessAndEqualAandLargeAreaPartition();
        int[] partition = lessNumberPartition.partition(arr, 0, arr.length - 1);
        ArrUtils.printArr(arr);
        ArrUtils.printArr(partition);
    }

}
