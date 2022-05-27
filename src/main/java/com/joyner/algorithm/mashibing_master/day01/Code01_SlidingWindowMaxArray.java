package com.joyner.algorithm.mashibing_master.day01;

import com.joyner.common.util.collection.ArrUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * 假设一个固定大小为W的窗口，依次划过arr，
 * 返回每一次滑出状况的最大值
 * 例如，arr = [4,3,5,4,3,3,6,7], W = 3
 * 返回：[5,5,5,4,6,7]
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
public class Code01_SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr, int w) {
        int[] res = new int[arr.length - w +1];
        int idx = 0;
        //用来维持窗口的最大值的优先级
        // 从大到小的顺序（存储的是索引）,从尾部进来的数，如果是大于等于尾部的数，则淘汰尾部的索引值
        Deque<Integer> maxDeque = new LinkedList();

        for (int i = 0; i < arr.length; i++) {
            //1.i位置准备进窗口，更新maxDeque的值
            //2.判断是否已经形成窗口
            //   2.1 (i - w + 1) >= 0 表明已经形成窗口，收集答案，请求计算过期的下标（i - w）
            //   来判断是否要更新maxDeque的值
            //获取淘汰的下标
            if (maxDeque.peekFirst() != null && (i - w) == maxDeque.peekFirst()) {
                maxDeque.pollFirst();
            }

            //淘汰之后在进入窗口
            Integer lastElIndex = maxDeque.peekLast();
            while (lastElIndex != null && arr[i] >= arr[lastElIndex]) {
                //直接弹出
                maxDeque.pollLast();
                lastElIndex = maxDeque.peekLast();
            }
            maxDeque.addLast(i);

            if (i - w + 1 >= 0) {
                //形成了窗口，收集答案
                res[idx++] = arr[maxDeque.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int w = 3;
        int[] maxWindow = getMaxWindow(arr, w);
        ArrUtils.printArr(maxWindow);
    }
}
