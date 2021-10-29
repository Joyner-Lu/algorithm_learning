package com.joyner.algorithm.mashibing_primary.dynamic;

/**
 * <pre>
 * N皇后问题是指在N*N的棋盘上要摆N个皇后，
 * 要求任何两个皇后不同行、不同列， 也不在同一条斜线上
 * 给定一个整数n，返回n皇后的摆法有多少种。  n=1，返回1
 * n=2或3，2皇后和3皇后问题无论怎么摆都不行，返回0
 * n=8，返回92
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
public class Code09_NQueens_V2 {

    public int totalNQueens(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32? -1 : (1 << n) - 1;
        int idx = 0;
        int r = process(limit, 0, 0, 0);
        return r;
    }

    private static int process(int limit,
                               int colLim,
                               int leftDiaLim,
                               int rightDiaLim) {
        if (colLim == limit) { // base case
            return 1;
        }
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }


    public static void main(String[] args) {



    }
}
