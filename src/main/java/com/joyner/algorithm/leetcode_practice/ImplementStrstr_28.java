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
public class ImplementStrstr_28 {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "aaaaa", needle = "bba";
        ImplementStrstr_28 implementStrstr_28 = new ImplementStrstr_28();
        int idx = implementStrstr_28.strStr(haystack, needle);
        System.out.println(idx);
    }
}
