package com.joyner.algorithm.leetcode_practice;

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
public class SumOfTwoIntegers_371 {


    public int getSum(int a, int b) {
        while (a != 0){
            System.out.println("a:" + toBinary(a));
            System.out.println("b:" + toBinary(b));
            int aAndB = (a & b);
            int newA = aAndB << 1;
            int newB = a ^ b;
            a = newA;
            b = newB;
            System.out.println("(a & b):" + toBinary(aAndB));
            System.out.println("(a & b) << 1:" + toBinary(a));
            System.out.println("a ^ b:" + toBinary(b));
        }
        return a | b;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers_371 sumOfTwoIntegers_371 = new SumOfTwoIntegers_371();
        int r = sumOfTwoIntegers_371.getSum(20, 30);
        System.out.println(r);
    }

    public static String toBinary(int n) {
        String b = Integer.toBinaryString(n);
        while (b.length() < 8) {
            b = "0" + b;
        }
        return b;
    }




}
