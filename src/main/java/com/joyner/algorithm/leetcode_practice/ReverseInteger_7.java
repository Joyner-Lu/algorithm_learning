package com.joyner.algorithm.leetcode_practice;

import java.util.HashMap;

import static java.lang.Integer.MAX_VALUE;

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
public class ReverseInteger_7 {

    public int reversev1(int x) {
        boolean isNegative = false;
        if (x == -2147483648) {
            return 0;
        }
        if (x < 0) {
            x = -x;
            isNegative = true;
        }


        if (x < 10) {
            if (isNegative) {
                return -x;
            }
            return x;
        }

        int s = x / 10;//求商
        int reg = x % 10;//求余数
        String result = (reg + "");
        while (s >= 10) {
            int temp = s;
            s = temp / 10;//求商
            reg = temp % 10;//求余数
            result += reg;
        }
        result += s;//加最后一位
        int resultInt = 0;
        try {
            resultInt = Integer.valueOf(result);
        } catch (Exception ex) {
            resultInt = 0;//超精读
        }

        if (isNegative) {
            resultInt = -resultInt;
        }
        return resultInt;

    }

    public int reverse(int x) {
        /**
         * 反转整数的方法可以与反转字符串进行类比。
         *
         * 我们想重复“弹出” xx 的最后一位数字，并将它“推入”到 \text{rev}rev 的后面。最后，\text{rev}rev 将与 xx 相反。
         *
         * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
         *
         *
         * //pop operation:
         * pop = x % 10;
         * x /= 10;
         *
         * //push operation:
         * temp = rev * 10 + pop;
         * rev = temp;
         * 但是，这种方法很危险，因为当 \text{temp} = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 时会导致溢出。
         *
         * 幸运的是，事先检查这个语句是否会导致溢出很容易。
         *
         * 为了便于解释，我们假设 \text{rev}rev 是正数。
         *
         */
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static void main(String[] args) {

        System.out.println(MAX_VALUE);

        ReverseInteger_7 reverseInteger_7 = new ReverseInteger_7();
        ReverseInteger_7 reverseInteger_1 = new ReverseInteger_7();

        //2147483647
        int r = reverseInteger_7.reverse(-2147483648);
        System.out.println(r);

        System.out.println(reverseInteger_7.hashCode());
        System.out.println(System.identityHashCode(reverseInteger_7));
        System.out.println(System.identityHashCode(reverseInteger_1));

        assert  1 == 2;
        System.out.println("111");
    }


    @Override
    public int hashCode() {
        return 1;
    }
}
