package com.joyner.algorithm.mashibing_primary;

/**
 * <pre>
 * 从min到max等概率返回
 * 范围：[min, max]
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@joyner.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class RandomBox {

    private int min;
    private int max;

    /**
     *
     * @param min
     * @param max
     */
    public RandomBox(int min, int max) {
        if (min > max) {
            throw new RuntimeException("参数传递错误,min=" + min + ",max=" + max);
        }
        this.min = min;
        this.max = max;

    }

    public int random() {

        //最大值 - 最小值 + 1 = 间隔
        //间隔 + 最小值 = 范围[min, max]
        return min +  (int)(Math.random()*(max - min + 1));
    }

    /**
     * 生成新的从newMin到newMax等概率返回
     * @param newMin
     * @param newMax
     * @return
     */
    public int random(int newMin, int newMax) {
        if(newMin >= newMax || newMax <= 1) {
            new RuntimeException("参数异常");
        }
        //1.计算二进制位的位数。也就是>=newMax需要的二进制位位数。
        int bitsNum = 1;
        int k = 1;
        while (k < newMax) {
            //左移一位，并且在0位置上补1
            k = (k<<1 | 1);
            bitsNum++;
        }

        int ans = 0;
        int bitsNumTmp = bitsNum;
        do {
            //每次重做ans清零
            ans = 0;
            while (bitsNum > 0) {
                ans += converToRandom01() << (bitsNum - 1);
                bitsNum--;
            }

            //还原位数
            bitsNum = bitsNumTmp;
            //小于最小值或者大于最大值重做
        } while (ans < newMin || ans > newMax);

        return ans;
    }


    /**
     * 转换为0和1等概率
     * @return
     */
    public int converToRandom01() {
        int size = max - min + 1;
        //求余数
        int remainder = size % 2;
        int mid = size / 2;
        //是否是奇数个
        boolean isOdd = remainder == 0 ? false : true;
        int ans = -1;
        do {
            ans = random() - min;
        } while (isOdd && ans == mid);

        return ans >= mid ? 1 : 0;

    }

    public static void main(String[] args) {
        int testTimes = 10000000;
        int d = 3<<1 | 1;
        System.out.println(d);
    }


}
