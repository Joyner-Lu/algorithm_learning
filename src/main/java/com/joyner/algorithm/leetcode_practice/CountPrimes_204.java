package com.joyner.algorithm.leetcode_practice;

import java.util.HashMap;

/**
 * <pre>
 *  大家中学都学过，就不过多介绍了，大致提两点：
 *
 *     质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数。
 *     0和1既不是质数也不是合数，最小的质数是2
 *
 *     a*b=c则 a 和b都是c的因数, b也可以表示位 c/a，也就是c/a必然也是 c的因数
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
public class CountPrimes_204 {


    public int countPrimes(int n) {


        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        //System.out.println("是质数：" + x);
        return true;
    }

    public boolean isPrimesv2(int x) {
        int tempX = x - 1;
        while (tempX > 1) {
            if (x % tempX == 0) {
                //能被其他数整除，因此不是质数
                return false;
            }
            tempX--;
        }
        System.out.println("质数：" + x);
        return true;
    }

    public static void main(String[] args) {
        CountPrimes_204 countPrimes_204 = new CountPrimes_204();
        int r = countPrimes_204.countPrimes(10);
        System.out.println(r);
    }

}
