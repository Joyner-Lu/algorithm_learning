package com.joyner.algorithm.leetcode_practice;

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
public class PowerOfThree_326 {

    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0 || n % 3 != 0 || n < 0) {
            return false;
        }

        int quotient = n / 3;
        while (true) {
            if (quotient == 1) {
                return true;
            }
            int temp = quotient % 3;
            if (temp != 0) {
                return false;
            }
            quotient = quotient / 3;
        }
    }

    public static void main(String[] args) {
        PowerOfThree_326 powerOfThree_326 = new PowerOfThree_326();
        boolean r = powerOfThree_326.isPowerOfThree(6);
        System.out.println(r);
    }
}
