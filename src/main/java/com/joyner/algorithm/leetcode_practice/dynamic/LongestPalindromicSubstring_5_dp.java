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
public class LongestPalindromicSubstring_5_dp {

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (isPalindrome(s)) {
            return s;
        }
        Vo[][] dp = new Vo[s.length()][s.length()];
        for (int L = 0; L < s.length() ; L++) {
            Vo vo = new Vo();
            dp[L][L] = vo;
            vo.str = s.charAt(L) + "";
            vo.isPalindrome = true;
        }

        for (int i = 1; i < s.length(); i++) {
            int L = 0;
            int R = i;
            while (L < s.length() && R < s.length()) {

                Vo r = new Vo();
                r.isPalindrome = isPalindrome(subStr(s, L, R));
                r.str = subStr(s, L, R);
                if (!r.isPalindrome)  {
                    Vo vo1 = dp[L][R - 1];
                    Vo vo2 = dp[L + 1][R];
                    Vo vo3 = dp[L + 1][R - 1];
                    r.isPalindrome = vo1.isPalindrome || vo2.isPalindrome || vo3.isPalindrome;
                    //其中有一个是回文
                    String maxStr = "";
                    if (vo1 != null && vo1.isPalindrome) {
                        maxStr = vo1.str;
                    }

                    if (vo2 != null && vo2.isPalindrome && vo2.str.length() > maxStr.length()) {
                        maxStr = vo2.str;
                    }

                    if (vo3 != null && vo3.isPalindrome && vo3.str.length() > maxStr.length()) {
                        maxStr = vo3.str;
                    }

                    r.str = maxStr;
                }
                dp[L][R] = r;
                L++;
                R++;
            }

        }

        return dp[0][s.length()-1].str;
    }

    class Vo {
        boolean isPalindrome = false;
        String str = "";
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
        LongestPalindromicSubstring_5_dp substring_5 = new LongestPalindromicSubstring_5_dp();
        String r = substring_5.longestPalindrome("dtgrtoxuybwyfskikukcqlvprfipgaygawcqnfhpxoifwgpnzjfdnhpgmsoqzlpsaxmeswlhzdxoxobxysgmpkhcylvqlzenzhzhnakctrliyyngrquiuvhpcrnccapuuwrrdufwwungaevzkvwbkcietiqsxpvaaowrteqgkvovcoqumgrlsxvouaqzwaylehybqchsgpzbkfugujrostopwhtgrnrggocprnxwsecmvofawkkpjvcchtxixjtrnngrzqpiwywmnbdnjwqpmnifdiwzpmabosrmzhgdwgcgidmubywsnshcgcrawjvfiuxzyzxsbpfhzpfkjqcpfyynlpshzqectcnltfimkukopjzzmlfkwlgbzftsddnxrjootpdhjehaafudkkffmcnimnfzzjjlggzvqozcumjyazchjkspdlmifvsciqzgcbehqvrwjkusapzzxyiwxlcwpzvdsyqcfnguoidiiekwcjdvbxjvgwgcjcmjwbizhhcgirebhsplioytrgjqwrpwdciaeizxssedsylptffwhnedriqozvfcnsmxmdxdtflwjvrvmyausnzlrgcchmyrgvazjqmvttabnhffoe");
        System.out.println(r);
    }
}
