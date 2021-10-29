package com.joyner.algorithm.leetcode_practice;

/**
 * <pre>
 *简单点就是循环32次，每次获取最后一位,也就是n&1，与结果（初始为0）相或（res=n&1|res），再将n右移，结果左移。 最终的结果就是反转的数了。具体看代码，可能表达不是很好。
 *
 * 举个例子：00001010->01010000 8位还是32位都一样。
 *
 *    开始：res：00000000   n:00001010     n&1
 *
 *          1：res：00000000  n:00001010       0
 *
 *          2：res：00000001  n:00000101       1
 *
 *          3：res：00000010  n:00000010       0
 *
 *          4：res：00000101  n:00000001       1
 *
 *          5：res：00001010  n:00000000       0
 *
 *          6：res：00010100  n:00000000       0
 *
 *          7：res：00101000  n:00000000       0
 *
 *          8：res：01010000  n:00000000       0
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class ReverseBits_190 {

    /**
     * 一直用1去试探第一位即可
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int count = 0;
        int result = 0;
        while (count < 32) {
            result <<= 1;//第一次不需要移动。本来就放在第一位（初始值，为零相当于没有移动）
            result = n&1 | result;
            n>>=1;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits_190 reverseBits_190 = new ReverseBits_190();
        reverseBits_190.reverseBits(5);
    }
}
