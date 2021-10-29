package com.joyner.algorithm.mashibing_primary.dynamic;

/**
 * <pre>
 * 假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2
 * 开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P，返回方法数。
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
public class RobotWalk_dpways {

    /**
     *
     * @param N 总共1到N个位置
     * @param M 起始位置     M的范围：1到N
     * @param K 必须走K步    K的范围：1到N
     * @param P 目标位置     P的范围：1到N
     * @return
     */
    public static int ways1(int N, int M, int K, int P) {
        //int curPos, int rest
        int[][] dp = new int[N + 1][K + 1];

        //按列更新
        for (int col = 0; col <= K; col++) {
            for (int row = 0; row <= N; row++) {
                if (row == 0) {
                    //不需要初始化，不可能等于0
                    continue;
                }
                if (col == 0) {
                    dp[row][col] = row == P? 1 : 0;
                } else if (row == 1) {
                    dp[row][col] = dp[2][col - 1];
                }  else if (row == N) {
                    dp[row][col] =  dp[N - 1][col - 1];
                } else {
                    dp[row][col] = dp[row - 1][col - 1] + dp[row + 1][col - 1];
                }
            }
        }
        return dp[M][K];
    }



    public static void main(String[] args) {
        //898517968
        System.out.println(ways1(10300, 2, 700, 600));
    }

}
