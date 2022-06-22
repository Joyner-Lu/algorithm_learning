package com.joyner.algorithm.leetcode_practice;

/**
 * <pre>
 *写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
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
public class ReverseString_344 {

    public void reverseString(char[] s) {
        //思路： a (=3)和 b(=5)互换可以写为
        // a = a + b
        // b = a - b; 8-5 = 3
        // a = a - b; 8-3 = 5

        //如果是偶数个
        int mid = s.length / 2;
        for (int i = 0; i < mid; i++) {
            int cFirst = s[i];
            int cLast = s[s.length-i-1];
            //互换位置
            cFirst = cFirst + cLast;
            cLast = cFirst - cLast;
            cFirst = cFirst - cLast;

            s[i] = (char)cFirst;
            s[s.length-i-1] = (char)cLast;
        }
    }

    public void reverseStringV2(char[] s) {
        int len = s.length;
        for (int left = 0,  right = len -1; left < right ; left++, right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseString_344 reverseString_344 = new ReverseString_344();
        char[] arr = {'1','2','4','5'};
        reverseString_344.reverseStringV2(arr);
        System.out.println(new String(arr));
    }
}
