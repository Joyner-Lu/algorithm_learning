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
public class QuikSort {

    private RandomBox randomBox = null;

    public void quickSort(int[] arr) {

        int l = 0;
        int r = arr.length - 1;
        quickSortHelp(arr, l, r);
    }

    /**
     * 从l到r上进行排序， 每次随机选择一个索引，然后和r位置进行交换，最后以r位置进行partition
     * @param arr
     * @param l
     * @param r
     */
    private void quickSortHelp(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        randomBox = new RandomBox(l, r -1);
        int randomIdx = randomBox.random();
        //交换
        ArrUtils.swap(arr, randomIdx, r);

        int[] partition = partition(arr, l, r);
        int equalLeftIdx = partition[0];
        int equalRightIdx = partition[1];
        //递归
        quickSortHelp(arr, l, equalLeftIdx -1);
        quickSortHelp(arr, equalRightIdx + 1, r);

    }


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
        int[] arr = {3, 8,-10,2,1,99, 20};
        QuikSort quikSort = new QuikSort();
        quikSort.quickSort(arr);
        ArrUtils.printArr(arr);
    }
}
