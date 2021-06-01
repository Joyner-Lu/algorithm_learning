package com.joyner.algorithm.leetcode_practice;

/**
 * <pre>
 *
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
public class ExcelSheetColumnNumber_171 {

    /**
     * 解题思路
     * 标签：字符串遍历，进制转换
     * 初始化结果 ans = 0，遍历时将每个字母与 A 做减法，因为 A 表示 1，所以减法后需要每个数加 1，计算其代表的数值 num = 字母 - ‘A’ + 1
     * 因为有 26 个字母，所以相当于 26 进制，每 26 个数则向前进一位
     * 所以每遍历一位则ans = ans * 26 + num
     *   ans * 26 是进位的意思，如果是10的，(应该就是 ans * 10,类比)
     * 以 ZY 为例，Z 的值为 26，Y 的值为 25，则结果为 26 * 26 + 25=701
     * 时间复杂度：O(n)O(n)
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;

    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber_171 demo = new ExcelSheetColumnNumber_171();
        System.out.println(demo.titleToNumber("ZY"));
    }
}
