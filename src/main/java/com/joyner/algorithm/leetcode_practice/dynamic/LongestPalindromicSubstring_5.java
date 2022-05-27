package com.joyner.algorithm.leetcode_practice.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * </pre>
 *"aacabdkacaa"  "aca"
 * @author 陆清云 luqy
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class LongestPalindromicSubstring_5 {

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        Map<String, Vo> dpMap = new HashMap<>();
        Vo vo = processV2(s, 0, s.length() - 1, dpMap);
        return vo.str;
    }

    class Vo {
        boolean isPalindrome = false;
        String str = "";
    }

    /**
     * 从l到r的范围上返回最大的回文数
     *
     * @param s
     * @param L
     * @param R
     * @return
     */
    private Vo processV2(String s, int L, int R, Map<String, Vo> dpMap) {
        String key = L + "-" + R;
        if (dpMap.get(key) != null) {
            return dpMap.get(key);
        }
        if (L > R) {
            Vo v = new Vo();
            dpMap.put(key, v);
            return v;
        }

        if (L == R) {
            Vo v = new Vo();
            v.isPalindrome = true;
            v.str = s.charAt(L) + "";
            dpMap.put(key, v);
            return v;
        }

        Vo r = new Vo();
        r.isPalindrome = isPalindrome(subStr(s, L, R));
        r.str = subStr(s, L, R);

        if (r.isPalindrome) {
            dpMap.put(key, r);
            return r;
        } else {
            //从L到R -1
            //从L + 1到R
            //从 L + 1到 R -1
            Vo vo1 = processV2(s, L, R - 1, dpMap);

            Vo vo2 = processV2(s, L + 1, R, dpMap);

            Vo vo3 = processV2(s, L + 1, R - 1, dpMap);

            r.isPalindrome = vo1.isPalindrome || vo2.isPalindrome || vo3.isPalindrome;
            if (!vo1.isPalindrome && !vo2.isPalindrome && !vo3.isPalindrome) {
                r.str = "";
            } else {
                //其中有一个是回文
                String maxStr = "";
                if (vo1.isPalindrome) {
                    maxStr = vo1.str;
                }

                if (vo2.isPalindrome && vo2.str.length() > maxStr.length()) {
                    maxStr = vo2.str;
                }

                if (vo3.isPalindrome && vo3.str.length() > maxStr.length()) {
                    maxStr = vo3.str;
                }

                r.str = maxStr;

            }
        }
        dpMap.put(key, r);
        return r;
    }

    /**
     * 从l到r范围上获取最大的回文数

     * @return
     */
    private String process(char[] chars, int idx, String path) {
        if (idx >= chars.length) {
            boolean palindrome = isPalindrome(path);
            if (palindrome) {
                return path;
            } else {
                return "";
            }
        }
        //不要当前字符
        String no = process(chars, idx + 1, path);
        //要当前字符

        String yes = process(chars, idx + 1, path + chars[idx]);
        String r = no.length() >= yes.length() ? no : yes;
        return r;
    }

    private static boolean isPalindrome(String str) {
        boolean result = true;
        int leftIdx = 0;
        int rightIdx = str.length() - 1;

        while (leftIdx <= rightIdx) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                result = false;
                break;
            }
            leftIdx++;
            rightIdx--;

        }
        return result;
    }

    /**
     * 截取从[L, R]范围的字符串
     *
     * @param str
     * @param L
     * @param R
     * @return
     */
    private static String subStr(String str, int L, int R) {
        R += 1;
        if (R > str.length()) {
            R = str.length();
        }
        if (L < 0) {
            L = 0;
        }
        return str.substring(L, R);

    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_5 substring_5 = new LongestPalindromicSubstring_5();
        String r = substring_5.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(r);

        int d = 1;

        String d1 = "\uD840\uDD70";
        String s = String.valueOf(d);
        System.out.println(d1);

        boolean supplementaryCodePoint = Character.isSupplementaryCodePoint(d);
        System.out.println(supplementaryCodePoint);

        boolean letter = Character.isLetter(d);
        System.out.println(letter);

        char[] chars = Character.toChars(d);
        System.out.println(String.valueOf(chars));

    }
}
