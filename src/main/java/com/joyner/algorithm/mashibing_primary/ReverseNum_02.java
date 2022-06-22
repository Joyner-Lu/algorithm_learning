package com.joyner.algorithm.mashibing_primary;

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
public class ReverseNum_02 {

    public int reverse(int num) {
        return ~num + 1;
    }

    public static void main(String[] args) {
        ReverseNum_02 reverseNum_02 = new ReverseNum_02();
        int reverse = reverseNum_02.reverse(5);
        System.out.println(reverse);

        //注意负数的最小取反还是负数，
        reverse = reverseNum_02.reverse(Integer.MIN_VALUE);
        System.out.println(reverse);

        //0取反还是0，因为溢出了
        reverse = reverseNum_02.reverse(0);
        System.out.println(reverse);

    }
}
