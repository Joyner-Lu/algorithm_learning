package com.joyner.algorithm.mashibing_primary.dynamic;

/**
 * <pre>
 * 给定两个长度都为N的数组weights和values，
 * weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少?
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
public class Code07_Knapsack {

    public static int getMaxValue(int[] w, int[] v, int bag) {
        return process(w, v,0,0, bag);
    }

    /**
     * 袋子的剩余空间
     *
     * @param w
     * @param v
     * @param rest
     * @return
     */
    private static int process(int[] w, int[] v, int val, int idx, int rest) {
        if (idx == w.length) {
            return val;
        }
        System.out.println(w[idx] + " 不要， 价值：" + (val) + ",idx:" + idx);
        int no = process(w, v, val, idx + 1, rest);

        int yes = Integer.MIN_VALUE;
        if (rest - w[idx] >= 0) {
            System.out.println(w[idx] + " 要， 价值：" + (val + v[idx]) + ",idx:" + idx);
            yes = process(w, v, val + v[idx], idx + 1, rest - w[idx]);
        } else {
            System.out.println(w[idx] + " 想要， 价值：" + (val + v[idx]) + ",idx:" + idx);
        }
        return Math.max(no, yes);
    }

    private static int processV2(int[] w, int[] v, int idx, int rest) {
        if( rest <= 0 || idx == w.length) {
            return 0;
        }

        int p1 = processV2(w, v, idx + 1, rest);
        int p2 = Integer.MIN_VALUE;
        if (rest - w[idx] >= 0) {
            p2 = v[idx] + processV2(w, v, idx + 1, rest - w[idx]);
        }
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] weights = { 2, 4, 11 };
        int[] values = { 6, 3, 19 };
        int bag = 11;
        System.out.println(getMaxValue(weights, values, bag));
    }
}
