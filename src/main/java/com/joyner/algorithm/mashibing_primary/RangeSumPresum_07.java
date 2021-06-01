package com.joyner.algorithm.mashibing_primary;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class RangeSumPresum_07 {

    private int[] preSum;

    public int rangeSum(int[] arr, int l , int r) {
        if (l > r || l < 0 || r >= arr.length) {
            throw new RuntimeException("参数传递错误");
        }
        if (preSum ==  null) {
            initPreSum(arr);
        }
        return l == 0 ? preSum[r] : preSum[r] - preSum[l - 1];
    }

    private void initPreSum(int[] arr) {
        int len = arr.length;
        preSum = new int[len];
        preSum[0] = arr[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 9};
        RangeSumPresum_07 rangeSumPresum_07 = new RangeSumPresum_07();

        int i = rangeSumPresum_07.rangeSum(arr, 2, 3);
        System.out.println(i);
    }


}
