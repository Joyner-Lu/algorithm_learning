package com.joyner.algorithm.mashibing_primary.dynamic;

/**
 * 最长公共子序列
 *
 * 多样本位置全对应的尝试模型
 */
public class Code05_LongCommonSequence {

	/**
	 * 	    	text2-0  text2-1 text2-2
	 * text1-0
	 * text1-1
	 *
	 * 1.第0行，也就是text1只有一个字符的时候，那么只要有一个字符相同，后续的都为1
	 * 2.第0列，也就是text2只有一个字符的时候，那么只要有一个字符相同，后续的都为1
	 * 3.如果最长公共子序列以text1和text2结尾，则 dp[i][j] = dp[i - 1][j - 1] + 1
	 * 4.如果最长公共子序列都不以text1和text2结尾，则 dp[i][j] = dp[i - 1][j - 1]
	 * 5.如果最长公共子序列以text1结尾，不以text2结尾，dp[i][j] = dp[i][j - 1]
	 * 6.如果最长公共子序列以text2结尾，不以text1结尾，dp[i][j] = dp[j][i - 1]
	 *
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		if (isEmpty(text1) || isEmpty(text2)) {
			return 0;
		}

		int[][] dp = new int[text1.length()][text2.length()];
		//更新第0行
		for (int col = 0; col < text2.length(); col++) {
			int val = (text1.charAt(0) == text2.charAt(col) ? 1 : 0);
			int max = val;
			if (col != 0) {
				max = Math.max(dp[0][col - 1], val);
			}
			dp[0][col] = max;
		}

		//更新第1列
		for (int row = 0; row < text1.length(); row++) {
			int val = (text2.charAt(0) == text1.charAt(row) ? 1 : 0);
			int max = val;
			if (row != 0) {
				max = Math.max(dp[row - 1][0], val);
			}
			dp[row][0] = max;
		}

		for (int i = 1; i < text1.length(); i++) {
			for (int j = 1; j < text2.length(); j++) {
				int max = Math.max(dp[i][j - 1], dp[i - 1][j]);
				if (text1.charAt(i) == text2.charAt(j)) {
					max = Math.max(dp[i - 1][j - 1] + 1, max);
				} else {
				    //TODO 这个可以不用，因为dp[i][j - 1]和dp[i - 1][j]做决策的时候，已经考虑过了。因此
                    //TODO dp[i][j - 1]和dp[i - 1][j]不可能比dp[i - 1][j - 1]小
					max = Math.max(dp[i - 1][j - 1], max);
				}
				dp[i][j] = max;
			}
		}


		return dp[text1.length() -1][text2.length() - 1];
	}
	public boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}

	public static void main(String[] args) {

	}

}
