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
 * @author 陆清云 luqy
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class Code09_NQueens {

    public static int num1(int n) {
        //下标代表行，值代表列
        int[] record = new int[n];
        int line = 0;
        int r = process(line, n, record);
        return r;
    }

    private static int process(int curLine, int n, int[] record) {
        if (curLine == n) {
            return 1;
        }
        int r = 0;
        for (int curColumn = 0; curColumn < n; curColumn++) {
            if (isValid(curLine, curColumn, record)) {
                //每行的下一个都是被覆盖的，不需要还原现场
                record[curLine] = curColumn;
                r += process(curLine + 1, n, record);
            }

        }
        return r;
    }


    /**
     * 判断要放的列是否合法
     * 看curLine - 1 行的斜线列是否和当前行当前需要放的（curLine，curColumn）冲突
     *
     * @param curLine
     * @param curColumn
     * @param record
     * @return
     */
    private static boolean isValid(int curLine, int curColumn, int[] record) {

        for (int preLine = 0; preLine < curLine; preLine++) {
            int preColumn = record[preLine];
            //判断是否共斜线。|x - x'| == |y - y'|
            if (preColumn == curColumn || Math.abs(preLine - curLine) == Math.abs(curColumn - preColumn)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(num1(4));
    }
}
