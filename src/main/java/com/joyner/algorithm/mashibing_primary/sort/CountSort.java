package com.joyner.algorithm.mashibing_primary.sort;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 *  一般来讲，计数排序要求，样本是整数，且范围比较窄
 *  例如：员工年龄排序，一般来讲，年龄不可能超过两百岁，所以
 *  准备200大小的数组，数组的下标就表示年龄，值时词频。
 *
 *  过程：遍历原数组，arr[val]++,最后统计词频表,
 *
 *
 *  基数排序时桶排序的一种，相当于建立了两百个桶，和样本的数据【状况】强相关。
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
public class CountSort {

    public void sort(int[] arr) {
        int[] help = new int[200];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < help.length; i++) {
            int frequency = help[i];
            while (frequency > 0) {
                arr[idx++] = i;
                frequency--;
            }
        }
        
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2,2, 5,2, 8, 90, 99};
        CountSort countSort = new CountSort();
        countSort.sort(arr);
        ArrUtils.printArr(arr);


    }

}
