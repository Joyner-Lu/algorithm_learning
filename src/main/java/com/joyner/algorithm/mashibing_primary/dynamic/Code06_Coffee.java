package com.joyner.algorithm.mashibing_primary.dynamic;

/**
 * <pre>
 * 给定一个数组，代表每个人喝完咖啡准备刷杯子的时间
 * 只有一台咖啡机，一次只能洗一个杯子，时间耗费a，洗完才能洗下一杯
 * 每个咖啡杯也可以自己挥发干净，时间耗费b，咖啡杯可以并行挥发
 * 返回让所有咖啡杯变干净的最早完成时间
 * 三个参数：int[] arr、int a、int b
 *
 * 例如：
 * 1.arr[1, 6, 12] 喝完的时间分别是1点，6点，12点， 如果a = 3（洗的时间） , b= 10（挥发时间）
 * 那么都洗的时间最短。 1点喝完开始洗，1 + 3 也就是到4点咖啡机器有空，6点的时候才喝完，继续洗， 6 + 3也就是9点的时候咖啡机有空
 * 12点才喝完，继续洗，那么就是12 + 3也就是所有杯子变干净的最早时间是15点
 *
 *
 * 2.arr[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 15] 如果a = 3（洗的时间） , b= 10（挥发时间）
 * 那么让15点前面的咖啡杯自己挥发干净，15点喝完的那杯洗，也就是 15 + 3，18点
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
public class Code06_Coffee {


    public static int minTime(int[] drinks, int a, int b) {
        return process(drinks, a, b, 0, 0);
    }

    // 方法二，洗咖啡杯的方式和原来一样，只是这个暴力版本减少了一个可变参数

    /**
     * 含义：第0到index-1 已经洗干净，从第index开始，洗干净后续杯子的所有最小时间
     *
     * @param drinks
     * @param a 洗咖啡的时间
     * @param b 让咖啡蒸发干的时间
     * @param index
     * @param washLine 咖啡机空闲的时间
     *
     * @return
     */
    public static int process(int[] drinks, int a, int b, int index, int washLine) {
        if (index == drinks.length - 1) {
            //最后一杯
            //挥发时间
            int dry = drinks[index] + b;
            //洗的时间，取喝完的时间和咖啡机有空的时间的最大值
            int wash = Math.max(washLine, drinks[index]) + a;
            return Math.min(dry, wash);
        }

        //不是最后一杯
        //1.洗 取当前喝完的时间和
        int wash = Math.max(washLine, drinks[index]) + a;
        int washNext = process(drinks, a, b, index + 1, wash);
        //当前杯干净且从index + 1杯也干净的最大值。也就是都要洗干净才算。
        int time1 = Math.max(wash, washNext);


        //2.挥发
        int dry = drinks[index] + b;
        int dryNext = process(drinks, a, b, index + 1, washLine);
        int time2 = Math.max(dry, dryNext);

        return Math.min(time1, time2);
    }


    public static int minTimeDp(int[] drinks, int a, int b) {
        int len = drinks.length;

        if (b < a) {
            //挥发时间小于洗的时间
            return drinks[len - 1] + b;
        }
        int washLineLimit = getWashLineLimit(drinks, a, b) + 1;
        int[][] dp = new int[len][washLineLimit];
        //更新最后一行
        for (int washLine = 0; washLine < washLineLimit; washLine++) {

            int dry = drinks[len - 1] + b;
            //洗的时间，取喝完的时间和咖啡机有空的时间的最大值
            int wash = Math.max(washLine, drinks[len - 1]) + a;
            dp[len - 1][washLine] = Math.min(dry, wash);

        }

        //更新其他行
        for (int i = len - 2; i >= 0 ; i--) {
            for (int washLine = 0; washLine < washLineLimit; washLine++) {
                //不是最后一杯
                //1.洗 取当前喝完的时间和
                int wash = Math.max(washLine, drinks[i]) + a;
                int time1 = Integer.MAX_VALUE;
                if (wash < washLineLimit) {
                    //有效解
                    int washNext = dp[i + 1][wash];
                    //当前杯干净且从index + 1杯也干净的最大值。也就是都要洗干净才算。
                    time1 = Math.max(wash, washNext);
                }


                //2.挥发
                int dry = drinks[i] + b;
                int dryNext = dp[i + 1][washLine];
                int time2 = Math.max(dry, dryNext);

                dp[i][washLine] = Math.min(time1, time2);
            }
        }


        return dp[0][0];

    }

    public static int getWashLineLimit(int[] drinks, int a, int b) {
        //washLine的最大值是。全洗
        int limit = 0;
        int washLine = 0;
        for (int i = 0; i < drinks.length; i++) {
            limit = Math.max(washLine, drinks[i]) + a;
            washLine = limit;
        }
        return limit;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 };
        int a = 3;
        int b = 10;
        //System.out.println(getWashLineLimit(arr, a, b));
        System.out.println(minTime(arr, a, b));

        System.out.println(minTimeDp(arr, a, b));
    }


}
