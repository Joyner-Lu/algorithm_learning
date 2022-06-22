package com.joyner.algorithm.mashibing_primary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * <pre>
 * 随机函数
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
public class RandomRelation {

    private int testTimes = 100000000;
    private int count = 0;


    private static final double DOUBLE_UNIT = 0x1.0p-53; // 1.0 / (1L << 53)

    /**
     * Math.random() 返回： [0, 1)
     */
    @Test
    public void testMathRandom() {
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() <= 0.3) {
                count++;
            }
        }

        System.out.println((double) count / testTimes);
        System.out.println(count);
        System.out.println(testTimes);

    }


    //[0,8) 等概率

    @Test
    public void testMathRandom2() {
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 4) {
                count++;
            }
        }

        System.out.println((double) count / testTimes);
    }

    @Test
    public void testMathRandomCount() {
        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * 8);
            counts[ans]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println("第" + i + "个出现的次数=" + counts[i]);
        }

        System.out.println((double) count / testTimes);

    }


    /**
     * 把[0,x) 范围上的概率修改为x平方
     */
    @Test
    public void changeProbabilityToXpower() {
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            double ans = toToXpower();
            if (ans < 0.3) {
                count++;
            }
        }

        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(0.3, 2));
    }


    // 返回[0,1)的一个小数
    // 任意的x，x属于[0,1)，[0,x)范围上的数出现概率由原来的x调整成x平方
    private double toToXpower() {
        //返回最大值，也就是只有两个都出现0-x范围的数的时候，才算成功
        //两次调用Math.random又是两个随机的独立事件，索引就是概率就是x的平方
        return Math.max(Math.random(), Math.random());

    }




    @Test
    public void testFromCtoDWithEqualProbability() {
        int min = 3;
        int max = 8;
        RandomBox randomBox = new RandomBox(min, max);
        int[] counts = new int[20];
        for (int i = 0; i < testTimes; i++) {
            int idx = randomBox.random();
            counts[idx]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println("第" + i + "个出现的次数=" + counts[i]);
        }
    }

    @Test
    public void testConvertTo01() {
        int min = 3;
        int max = 8;
        RandomBox randomBox = new RandomBox(min, max);
        int[] counts = new int[20];
        for (int i = 0; i < testTimes; i++) {
            int idx = randomBox.converToRandom01();
            counts[idx]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println("第" + i + "个出现的次数=" + counts[i]);
        }
    }

    @Test
    public void convertToNewRange() {
        //已知3到8等概念率返回
        int min = 3;
        int max = 8;
        RandomBox randomBox = new RandomBox(min, max);
        //求2-4等概率返回
        int newMin = 2;
        int newMax = 4;
        int[] counts = new int[20];
        for (int i = 0; i < testTimes; i++) {
            int idx = randomBox.random(newMin, newMax);
            counts[idx]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println("第" + i + "个出现的次数=" + counts[i]);
        }
    }

    public static void main(String[] args) {
        RandomRelation randomRelation = new RandomRelation();
        List<Integer> list = new ArrayList<>();
        list.forEach(integer -> {

        });

    }

    /**
     * 非等概率返回0和1
     * 返回1的概率 70%
     * 返回0的概率 30%
     * @return
     */
    public int nonEqualProbability01() {
        //返回1的概率 70%
        return Math.random() <= 0.7 ? 0 : 1;
    }


    /**
     * 利用nonEqualProbability01函数等概率返回0和1
     * 返回0的概率是p 返回1的概率是1-p
     * 那么我只要返回0和1或者1和0的。
     * 这样返回的概率一定是p*(1-p),也就是等概率返回
     * @return
     */
    public int convertToEqualProbability01() {
        int ans = 0;
        do {
            //返回0和0重做
            //返回1和1重做
            ans = nonEqualProbability01();
        } while (ans == nonEqualProbability01());
        return ans;
    }

    @Test
    public void testNonEqualProbability01() {
        int[] counts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            int ans = nonEqualProbability01();
            counts[ans]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println("第" + i + "个出现的次数=" + counts[i]);
        }

    }

    @Test
    public void testConvertToEqualProbability01() {
        int[] counts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            int ans = convertToEqualProbability01();
            counts[ans]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println("第" + i + "个出现的次数=" + counts[i]);
        }
    }

    private static long next(int i) {
        return 0;
    }


}
