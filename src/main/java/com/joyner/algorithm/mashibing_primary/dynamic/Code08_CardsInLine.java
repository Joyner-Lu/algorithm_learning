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
public class Code08_CardsInLine {

    public static int win1(int[] arr) {
        return Math.max(f(arr, 0, arr.length-1), s(arr, 0, arr.length - 1));
    }

    /**
     * 先手的情况下，我从l到r上拿到的最大值
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int f(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        //1.拿左边
        int leftMax = arr[l] + s(arr, l + 1, r);

        //2.拿右边
        int rightMax = arr[r] + s(arr, l, r - 1);
        return Math.max(leftMax, rightMax);

    }

    /**
     * 后手的情况下，我从l到r上拿到的最大值
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int s(int[] arr, int l, int r) {
        if (l == r) {
            //后手，如果我只有一张票，必然别人先拿走
            return 0;
        }

        //1.对方拿右边
        int leftMin = f(arr, l + 1, r);

        //2.对方拿左边
        int rightMin = f(arr, l, r - 1);

        //后手拿的，必然对我不利
        return Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 9, 1 };
        System.out.println(win1(arr));
    }
}
