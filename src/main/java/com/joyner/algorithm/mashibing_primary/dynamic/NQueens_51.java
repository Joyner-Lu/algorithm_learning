package com.joyner.algorithm.mashibing_primary.dynamic;

import com.joyner.common.util.collection.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
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
public class NQueens_51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        //下标代表行，值代表列
        int[] record = new int[n];
        int line = 0;
        int r = process(line, n, record, result);
        System.out.println(r);
        return result;

    }
    //[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    private static int process(int curLine, int n, int[] record, List<List<String>> result) {
        if (curLine == n) {
            List<String> r = new ArrayList<>();
            for (int line = 0; line < record.length; line++) {
                int positionCol = record[line];

                String lineR = "";
                for (int column = 0; column < record.length; column++) {
                    if (positionCol == column) {
                        lineR += "Q";
                    } else {
                        lineR += ".";
                    }
                }
                r.add(lineR);

            }
            result.add(r);
            return 1;
        }
        int r = 0;
        for (int curColumn = 0; curColumn < n; curColumn++) {
            if (isValid(curLine, curColumn, record)) {
                //每行的下一个都是被覆盖的，不需要还原现场
                record[curLine] = curColumn;
                r += process(curLine + 1, n, record, result);
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
        NQueens_51 nQueens_51 = new NQueens_51();
        List<List<String>> lists = nQueens_51.solveNQueens(4);
        ListUtil.printStr(lists);
    }
}
