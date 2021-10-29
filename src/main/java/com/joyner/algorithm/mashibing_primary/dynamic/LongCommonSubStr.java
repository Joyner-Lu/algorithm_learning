package com.joyner.algorithm.mashibing_primary.dynamic;

/**
 * <pre>
 * 求两个字符串的最长公共子序列
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class LongCommonSubStr {

    public int findLongest(String str1, String str2) {
        if (isEmpty(str1) || isEmpty(str2)) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int[][] dp = new int[str1.length()][str2.length()];

        //更新0行
        for (int col = 0; col < str2.length(); col++) {
            dp[0][col] = str1.charAt(0) == str2.charAt(col) ? 1 : 0;
            result = Math.max(result, dp[0][col]);
        }

        //更新0列
        for (int row = 0; row < str1.length(); row++) {
            dp[row][0] = str1.charAt(row) == str2.charAt(0) ? 1 : 0;
            result = Math.max(result, dp[row][0]);

        }

        //更新任何一个i和j的位置
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;

    }

    public boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static void main(String[] args) {
        System.out.println(new LongCommonSubStr().findLongest("abc", "d"));
    }
}
