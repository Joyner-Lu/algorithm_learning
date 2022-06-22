package com.joyner.algorithm.mashibing_primary;

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
public class SelectSort_04 {

    public void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minVal = arr[i];
            int minValIdx = i;
            //0~n-1 找最小
            //1~n-1 找最小
            //2~n-1 找最小
            //...
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minVal = arr[j];
                    minValIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = minVal;
            arr[minValIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 8, 9, 55, -3};
        SelectSort_04 selectSort_04 = new SelectSort_04();
        selectSort_04.selectSort(arr);
        ArrUtils.printArr(arr);
    }
}
