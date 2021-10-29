package com.joyner.algorithm.mashibing_primary.dynamic;

/**
 * <pre>
 *给定一个整型数组arr，代表数值不同的纸牌排成一条线，
 * 玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，
 * 但是每个玩家每次只能拿走最左或最右的纸牌，
 * 玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
 *
 * 所谓的玩家都很聪明是指：一个玩家做的策略不会让另外一个玩家得到好处。例如
 *
 * 1 2 1000 90
 *
 * A先拿牌：他必然不拿90，因为拿90，会暴露1000给B,所以A拿1
 *
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
public class Code08_CardsInLineDpWays {

    public static int win1(int[] arr) {
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];

        //初始化f的斜线，s的斜线不用初始化，因为都是0.
        for (int i = 0; i < arr.length; i++) {
            f[i][i] = arr[i];
        }

        //开始初始化f 和 s
        for (int idx = 1; idx < arr.length; idx++) {
            int R = idx;
            int L = 0;
            while (L < arr.length && R < arr.length) {
                int leftMax = arr[L] + s[L + 1][R];
                int rightMax = arr[R] + s[L][R - 1];
                f[L][R] = Math.max(leftMax, rightMax);
                s[L][R] = Math.min(f[L + 1][R], f[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(f[0][arr.length -1], s[0][arr.length - 1]);
    }



    public static void main(String[] args) {
        int[] arr = { 1, 9, 1 };
        System.out.println(win1(arr));
    }
}
