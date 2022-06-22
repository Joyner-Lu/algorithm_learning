package com.joyner.algorithm.leetcode_practice;


import java.util.HashMap;

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
public class HappyNumber_202 {


    HashMap cycle = new HashMap();

    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            cycle.put(n, n);
            n = cal(n);
            if (cycle.get(n) != null) {
                //循环了
                return false;
            }

        }
        return true;
    }

    private int cal(int n) {
        int sum = 0;
        int div = n;
        while (n >= 10) {
            div = n / 10;
            int req = n % 10;
            sum += req * req;
            n = div;
        }
        sum += div * div;

        return sum;
    }

    public static void main(String[] args) {
        HappyNumber_202 happyNumber_202 = new HappyNumber_202();
        boolean r = happyNumber_202.isHappy(5);
        System.out.println(r);
    }
}
