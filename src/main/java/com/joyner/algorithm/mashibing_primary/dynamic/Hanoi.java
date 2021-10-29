package com.joyner.algorithm.mashibing_primary.dynamic;

/**
 * <pre>
 * 汉诺塔（Tower of Hanoi），又称河内塔，是一个源于印度古老传说的益智玩具。大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
 *
 * 方法：
 * 1.把从1到N-1的盘子从左边移到中间
 * 2.把第N个盘子从左边移到右边
 * 3.把从1到N-1的盘子从中间移到右边
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
public class Hanoi {


    public void hanoiV1(int n) {
        leftToRight(n);
    }

    private void leftToRight(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from left to right");
            return;
        }
        //1.把从1到N-1的盘子从左边移到中间
        leftToMid(n - 1);
        //2.把第N个盘子从左边移到右边
        System.out.println("move " + n + " from left to right");
        //3.把从1到N-1的盘子从中间移到右边
        midToRight(n - 1);
    }

    private void leftToMid(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from left to mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("move " + n + " from left to mid");
        rightToMid(n - 1);
    }

    private void midToRight(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from mid to right");
            return;
        }
        //需求变成：把n个圆盘从中间移到右边
        midToLeft(n - 1);
        System.out.println("move " + n + " from mid to right");
        leftToRight(n - 1);
    }

    private void midToLeft(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from mid to left");
            return;
        }
        midToRight(n - 1);
        System.out.println("move " + n + " from mid to left");
        rightToLeft(n - 1);
    }

    private void rightToMid(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from right to mid");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("move " + n + " from right to mid");
        leftToMid(n - 1);

    }

    private void rightToLeft(int n) {
        if (n == 1) {
            System.out.println("move " + n + " from right to left");
            return;
        }
        rightToMid(n - 1);
        System.out.println("move " + n + " from right to left");
        midToLeft(n - 1);
    }

    public void hanoiV2(int n) {
        hanoiHelp(n, "left", "right", "mid");
    }

    private void hanoiHelp(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("move " + n + " from " + from + " to " + to);
            return;
        }
        hanoiHelp(n - 1, from, other, to);
        System.out.println("move " + n + " from " + from + " to " + to);
        hanoiHelp(n - 1, other, to, from);

    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoiV1(3);

        System.out.println("======");
        hanoi.hanoiV2(3);
    }

}
