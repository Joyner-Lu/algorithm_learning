package com.joyner.algorithm.mashibing_primary;

/**
 * <pre>
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
public class PrintBinary_01 {

    private static final int INT_LENGTH = 32;

    public void print(int num) {
        for (int i = INT_LENGTH - 1; i >= 0; i--) {
            int temp = 1 << i;
            int r  = num & temp;
            if (r == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrintBinary_01 p = new PrintBinary_01();
        p.print(Integer.MAX_VALUE);

        //取反操作  n 的取反 ~n + 1
        int a = 5;
        int d = ~a + 1;
        System.out.println(a);
        System.out.println(d);
    }
}
