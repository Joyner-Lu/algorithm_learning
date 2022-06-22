package com.joyner.algorithm.mashibing_trainingcamp001.day01;

/**
 * <pre>
 *给定一个整型数组arr，和一个整数num
 * 某个arr中的子数组sub，如果想达标，必须满足：
 * sub中最大值 – sub中最小值 <= num，
 * 返回arr中达标子数组的数量
 *
 * 备注：子数组是连续的
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
public class Code02_AllLessNumSubArray {

    /**
     * 暴力版本
     * @param arr
     * @param num
     * @return
     */
    public int getNumV1(int[] arr, int num) {
        int numR = 0;
        for (int l = 0; l < arr.length; l++) {
            //[l..l] [l..l+1] [l..l+2]  [l...n-1]
            for (int r = l; r < arr.length; r++) {
                int[] resultArr  = buidArr(l, r, arr);
                printResult(resultArr);
                int max = maxArr(resultArr);
                int min = minArr(resultArr);
                if (max - min <= num) {
                    numR++;
                }
            }
        }
        return numR;
    }

    private int[] buidArr(int l, int r, int[] arr) {
        int[] result = new int[r - l + 1];
        int idx = 0;
        for (int i = l; i <= r; i++) {
            result[idx] = arr[i];
            idx++;
        }
        return result;
    }

    public int maxArr(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public int minArr(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }


    private static void printResult(int[] result) {
        System.out.print("result：[");
        for (int el : result) {
            System.out.print(el + ",");
        }
        System.out.print("]");
        System.out.println();

    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        Code02_AllLessNumSubArray allLessNumSubArray = new Code02_AllLessNumSubArray();
        int r = allLessNumSubArray.getNumV1(arr, 3);
        System.out.println("结果：" + r);
    }
}
