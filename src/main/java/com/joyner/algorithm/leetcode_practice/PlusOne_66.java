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
public class PlusOne_66 {

    public int[] plusOne(int[] digits) {
        int newArrLen = digits.length;
        boolean isLastNumOverflow = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int plusResult = digits[i] + 1;
            if (plusResult >= 10) {
                int reminder = plusResult % 10;
                digits[i] = reminder;
                if (i == 0) {
                    //第一位相加还大于1，则需要扩大新数组长度
                    newArrLen++;
                    isLastNumOverflow = true;
                }
            } else {
                digits[i] = plusResult;
                break;
            }
        }
        int[] newArr = new int[newArrLen];
        for (int i = 0; i < digits.length; i++) {
            if (isLastNumOverflow && i == 0) {
                newArr[i] = 1;
            } else {
                newArr[i] = digits[i];
            }
        }
        return newArr;
    }
}
