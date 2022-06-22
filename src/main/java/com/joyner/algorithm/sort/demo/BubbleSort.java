package com.joyner.algorithm.sort.demo;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 *
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
public class BubbleSort {

    public void bubbleSort(int[] targetArr) {
        for (int i = 0; i < targetArr.length - 1; i++) {
            boolean isExchange = false;
            for (int j = 0; j < targetArr.length - 1 - i; j++) {
                int cur = targetArr[j];
                int next = targetArr[j+1];
                if (cur > next) {
                    int temp = targetArr[j+1];
                    targetArr[j+1] = cur;
                    targetArr[j] = temp;
                    isExchange = true;
                }
            }

            if (!isExchange) {
                //某次冒泡没有交换则直接跳出循环
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        ArrUtils.printArr(arr);
    }
}
