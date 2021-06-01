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
public class LongestCommonPrefix_14 {

    /**
     * 按列来索引，以第一列为最小长度，在循环里面会判断是否超过该字符串的长度
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) {
            return result;
        }

        if (strs.length == 1) {
            return strs[0];
        }


        int minLen = strs[0].length();

        out:
        for (int i = 0; i < minLen; i++) {
            char tempC = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    //如果超过该字符串的长度，超过跳出
                    break out;
                }

                char c1 = strs[j].charAt(i);
                if (tempC != c1) {
                    flag = false;
                    break out;
                }
            }
            if (flag) {
                result += tempC;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", ""};
        LongestCommonPrefix_14 longestCommonPrefix_14 = new LongestCommonPrefix_14();
        String str = longestCommonPrefix_14.longestCommonPrefix(strs);
        System.out.println(str);
    }
}
