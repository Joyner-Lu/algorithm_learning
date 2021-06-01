package com.joyner.algorithm.mashibing_primary;

import javax.sound.midi.Soundbank;

/**
 * <pre>
 *不用任何比较判断找出两个数中较大的数<br>
 *     1.如果都是正数，从最高位不断试探两个数1的位置，如果有个数出现1，另外一个是0，则出现1的必然大。
 *     2.一正一负，则返回负数.
 *
 *     备注：都是负数的时候，最高位表示负数，
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
public class CompareTwoNums {

    public int compare(int a, int b) {
        int test = 1 << 31;
        //试探符号位
        boolean isANeg = (test & a) == 0 ? false : true;
        boolean isBNeg = (test & b) == 0 ? false : true;
        if (!isANeg && isBNeg) {
            //a非负，b是负数
            return a;
        }

        if (isANeg && !isBNeg) {
            return b;
        }


        int aR = 0;
        int bR = 0;
        do {
            //都是正数
            test = test >>> 1;
            aR = (a & test);
            bR = (b & test);

        } while (aR == bR && test != 1);
        return aR == 0 ? b : a;

    }


    public void test33(int a, int b) {
        int diff = (a - b) << 2;
        String[] arr = {"a=b", "a>b", "a<b"};
        try {
            System.out.println(arr[diff]);
        } catch (ArrayIndexOutOfBoundsException e) {
            int index = diff >>> 31;
            System.out.println(arr[index + 1]);
        }
    }

    public int compareForTest(int a, int b) {
        return a >= b ? a : b;
    }

    public static void main(String[] args) {
        CompareTwoNums compareTwoNums = new CompareTwoNums();
        RandomBox randomBox = new RandomBox(-1000, 1000);
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            int a = randomBox.random();
            int b = randomBox.random();
            int result = compareTwoNums.compare(a, b);
            int testResult = compareTwoNums.compareForTest(a, b);
            if (result != testResult) {
                throw new RuntimeException("a:" + a + ",b:" + b + ",result:" + result);
            } else {
                System.out.println("a:" + a + ",b:" + b + ",result:" + result);
                compareTwoNums.test33(a, b);
            }

        }

        System.out.println("perfect!!!");

        CompareTwoNums compareTwoNums1 = new CompareTwoNums();
        int result = compareTwoNums1.compare(Integer.MIN_VALUE, Integer.MIN_VALUE + 1);
        System.out.println(result);



    }

}
