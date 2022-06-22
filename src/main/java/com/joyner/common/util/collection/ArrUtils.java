package com.joyner.common.util.collection;

import java.util.Collections;

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
public class ArrUtils {

    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            String comma = i == arr.length - 1 ? "" : ",";
            System.out.print(arr[i] + comma);
        }
        System.out.print("]");
        System.out.println();

    }

    public static <T>void commonPrintArr(T[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            String comma = i == arr.length - 1 ? "" : ",";
            System.out.print(arr[i] + comma);
        }
        System.out.print("]");
        System.out.println();
    }


    public static int[] arrCopy(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }


    /**
     * 是否升序排序
     * @param arr
     * @return
     */
    public static boolean isAscSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 把数组i和j位置互换
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 把数组i和j位置互换
     */
    public static <T>void commonSwap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swapCharArr(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}


