package com.joyner.algorithm.mashibing_primary;

/**
 * <pre>
 * 计算 1！+2！+...+n！
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
public class SumOfFactorial_03 {

    public int sumOfFactorial(int n) {
        int cur = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            sum += cur;
        }

        return sum;
    }

    public static void main(String[] args) {
        SumOfFactorial_03 sumOfFactorial_03 = new SumOfFactorial_03();
        int i = sumOfFactorial_03.sumOfFactorial(4);
        System.out.println(i);
    }
}
