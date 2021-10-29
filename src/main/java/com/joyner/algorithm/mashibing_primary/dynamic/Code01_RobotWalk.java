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
public class Code01_RobotWalk {

    /**
     *
     * @param N 总共1到N个位置
     * @param M 起始位置     M的范围：1到N
     * @param K 必须走K步    K的范围：1到N
     * @param P 目标位置     P的范围：1到N
     * @return
     */
    public static int ways1(int N, int M, int K, int P) {
        int r = process(N, M, K, P);
        return r;
    }

    /**
     *
     * @param n
     * @param curPos
     * @param rest
     * @param targetPos
     * @return
     */
    private static int process(int n, int curPos, int rest, int targetPos) {
        if (rest == 0) {
            return targetPos == curPos ? 1 : 0;
        }
        if (curPos == 1) {
            return process(n, 2, rest - 1, targetPos);
        }
        if (curPos == n) {
            return process(n, n - 1, rest - 1, targetPos);
        }
        return process(n, curPos - 1, rest - 1, targetPos) + process(n, curPos + 1, rest - 1, targetPos);
    }

    public static void main(String[] args) {
        int i = ways1(7, 2, 5, 3);
        System.out.println(i);
    }

}
