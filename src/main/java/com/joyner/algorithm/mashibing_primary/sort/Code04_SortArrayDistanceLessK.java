package com.joyner.algorithm.mashibing_primary.sort;

import com.joyner.algorithm.mashibing_primary.MyBigHeap;
import com.joyner.algorithm.mashibing_primary.MySmallHeap;
import com.joyner.common.util.collection.ArrUtils;

import java.util.Arrays;

/**
 * <pre>
 * 一个无序的数组，如果排好序之后，每个元素移动的距离都不会超过k,请选择一个合适的排序算法对其进行排序
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
public class Code04_SortArrayDistanceLessK {

    /**
     * 思路：首先，第一个元素的范围一定在0到k内。也就是k+1个元素内
     *      那么构建k+1个元素的小根堆，然后弹出，放入第一个元素，
     *      把k+2个放入小根堆，继续弹出
     *
     * @param arr
     * @param k
     */
    public static void sortedArrDistanceLessK(int[] arr, int k) {
        MySmallHeap mySmallHeap = new MySmallHeap(k + 1);
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!mySmallHeap.isFull()) {
                mySmallHeap.push(arr[i]);
            } else {
                int pop = mySmallHeap.pop();
                arr[idx++] = pop;
                mySmallHeap.push(arr[i]);
            }
        }

        while (!mySmallHeap.isEmpty()) {
            int pop = mySmallHeap.pop();
            arr[idx++] = pop;
        }
    }

    // for test
    public static int[] randomArrayNoMoveMoreK(int maxSize, int maxValue, int K) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        // 先排个序
        Arrays.sort(arr);
        // 然后开始随意交换，但是保证每个数距离不超过K
        // swap[i] == true, 表示i位置已经参与过交换
        // swap[i] == false, 表示i位置没有参与过交换
        boolean[] isSwap = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = Math.min(i + (int) (Math.random() * (K + 1)), arr.length - 1);
            if (!isSwap[i] && !isSwap[j]) {
                isSwap[i] = true;
                isSwap[j] = true;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return arr;
    }

    // for test
    public static void main(String[] args) {
        /*System.out.println("test begin");
        int[] arr = {0, -1, -7, 7, 2};
        sortedArrDistanceLessK(arr, 2);
        ArrUtils.printArr(arr);*/

        System.out.println("test begin");
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int k = (int) (Math.random() * maxSize) + 1;
            int[] arr = randomArrayNoMoveMoreK(maxSize, maxValue, k);
            int[] copy = ArrUtils.arrCopy(arr);
            sortedArrDistanceLessK(arr, k);
            if (!ArrUtils.isAscSorted(arr)) {
                ArrUtils.printArr(copy);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    // for test
    public static void comparator(int[] arr, int k) {
        Arrays.sort(arr);
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
