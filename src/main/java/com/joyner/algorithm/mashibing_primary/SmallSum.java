package com.joyner.algorithm.mashibing_primary;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 * 在一个数组中，每一个元素左边比当前元素值小的元素值累加起来，叫做这个数组的小和
 * 例如：[2,3,4,1,5]
 * 2左边比2小的元素：无
 * 3左边比3小的元素：2
 * 4左边比4小的元素：2，3
 * 1左边比1小的元素：无
 * 5左边比5小的元素：2,3,4,1
 * 小和small_sum = 2 + 2 + 3 + 2 + 3 + 4 + 1 = 17
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
public class SmallSum {


    /**
     * 暴力法
     *
     * @return
     */
    public int samllSumV1(int[] arr) {
        //0-(0) 看左边比他小的数，记录起来
        //0-(1)
        //0-(2)
        //0-(n)
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < target) {
                    ans += arr[j];
                }
            }
        }

        return ans;

    }


    /**
     * 利用归并排序来实现，思路。<br>
     * 1.可以这样理解题目，当前数target，在右边由几个数比我大，那么就有n*target
     * 例如：2，右边比我大的就有3个，那么结果加上 res += 3*2
     * 3，右边比我大的就有2个，那么结果加上 res += 2*3
     * 4，右边比我大的就有1个，那么结果加上 res += 1*4
     * 1，右边比我大的就有1个，那么结果加上 res += 1*1
     * 5，右边比我大的没有，   那么结果加上 res += 0
     * 最后：res = 17
     * <p>
     * 2.哪如果使用归并排序来进行处理呢。
     * [2,3,4,1,5]
     * [2,3] merge,那边2比3小，在2到3范围上，有1个2。=2
     * [4,1] merge,4没有比1，小在[4,1]范围上，没有
     * [2,3]  [1,4]进行merge,   2在[1,4]这个范围上，比他大的就1个4，那么有1个2，3在[1,4]范围上，比他大的也有一个4，那么有1个3==1*2+1*3 = 5
     * [1,2,3,4] [5] 进行merge, 同理有，1个1，1个2，1个3，1个4= 10
     *
     * @param arr
     * @return
     */
    public int samllSumV2(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        return samllSumHelp(arr, l, r);
    }

    private int samllSumHelp(int[] arr, int l, int r) {
        if (l == r) {
            //只有一个收集为0
            return 0;
        }
        int div2 = (r - l) >> 1;
        int mid = l + div2;
        //返回给上一层使用
        int left = samllSumHelp(arr, l, mid);
        //返回给上一层使用
        int right = samllSumHelp(arr, mid + 1, r);
        int merge = merge(arr, l, mid, r);
        return left + right + merge;
    }

    private int merge(int[] arr, int l, int mid, int r) {

        int res = 0;
        int len = r - l + 1;
        int[] help = new int[len];
        int p1 = l;
        int p2 = mid + 1;
        int idx = 0;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] < arr[p2]) {
                //当前的p2比p1大，证明后面的都比p1大，因为是有序的
                int nums = r - p2 + 1;
                res += (nums * arr[p1]);
            }

            //p1小拷贝p1,并且指针往下移，对p2同理
            help[idx++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //拷贝剩余的
        while (p1 <= mid) {
            help[idx++] = arr[p1++];
        }

        while (p2 <= r) {
            help[idx++] = arr[p2++];
        }
        //往回拷贝
        for (int i = 0; i < help.length; i++) {
            arr[i + l] = help[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5};
        SmallSum smallSum = new SmallSum();
        int i = smallSum.samllSumV2(arr);
        System.out.println(i);
        ArrUtils.printArr(arr);


    }


}
