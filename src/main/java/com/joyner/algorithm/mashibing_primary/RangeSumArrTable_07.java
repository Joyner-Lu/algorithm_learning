package com.joyner.algorithm.mashibing_primary;

/**
 * <pre>
 * 求从L到R位置的数据
 * 生成表格的方式，也就是 n* n的表格
 * sum(arr, L, R)
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
public class RangeSumArrTable_07 {

    private int[][] table = null;


    public int sumRange(int[] arr, int l, int r) {
        if (l > r) {
            throw new RuntimeException("参数传递错误");
        }
        if (table == null) {
            initTable(arr);
        }
        int ans = table[l][r];
        return ans;
    }

    /**
     * 0-0表示0到0的和
     * 0-2表示0到2的和
     * 2-5 表示2到5的和
     * 且有个特点：例如：0-1的和等于0-0的和加上arr[1],如此类推
     * @param arr
     */
    private void initTable(int[] arr) {
        int len = arr.length;
        table = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i <= j) {
                    if (i == j) {
                        table[i][j] = arr[j];
                    } else {
                        table[i][j] = table[i][j - 1] + arr[j];
                    }

                }
                
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 9};
        RangeSumArrTable_07 arrTable_07 = new RangeSumArrTable_07();
        int r = arrTable_07.sumRange(arr, 1, 4);
        System.out.println(r);
    }


}
