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
public class ValidPalindrome_125 {


    public boolean isPalindrome(String s) {
        int headIdx = 0;
        int tailIdx = s.length() - 1;

        while (headIdx <= tailIdx) {
            char headChar = s.charAt(headIdx);
            char tailChar = s.charAt(tailIdx);
            if ((headChar = convert(headChar)) == '!') {
                headIdx++;
                continue;
            }
            if ((tailChar = convert(tailChar)) == '!') {
                tailIdx--;
                continue;
            }

            int r = headChar - tailChar;
            if (r != 0) {
                return false;
            }
            headIdx++;
            tailIdx--;
        }

        return true;
    }

    /**
     * 是否可比较，只有数字和字母字符可以比较
     * @param c
     * @return
     */
    private char convert(char c) {
        char mask = 0xDF;
        //48-57 '0'-'9'
        if (c >= 48 && c <= 57) {
            return c;
        }

        //65-90 'A'-'Z'
        if (c >= 65 && c <= 90) {
            return c;
        }

        //97-122 'a'-'z'
        if (c >= 97 && c <= 122) {
            // 65的二进制：0100 0001
            // 97的二进制：0110 0001
            //也就是第6为不同,变为大写字母，则把第6位去掉。
            //也就是和 1101 1111相与
            //c -= 32;
            return (char)(c & mask);
        }
        return '!';
    }


    public static void main(String[] args) {
        ValidPalindrome_125 validPalindrome_125 = new ValidPalindrome_125();

        //97-122 'a'-'z'
        //65-90 'A'-'Z'
        //48-57 '0'-'9'
        //System.out.println((int)'9');
        //System.out.println(validPalindrome_125.isComparable(','));
        System.out.println(validPalindrome_125.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
