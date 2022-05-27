package com.joyner.algorithm.mashibing_primary.dynamic;

import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 *  规定1和A对应、2和B对应、3和C对应...
 * 那么一个数字字符串比如"111”就可以转化为:
 * "AAA"、"KA"和"AK"
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 *
 * 注意如果字符串包含0，则不能转换
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
public class Code06_ConvertToLetterString {

    public int translateNum(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        return process(chars, 0);
    }

    private static int process(char[] chars, int idx) {
        if (idx == chars.length) {
            //说明找到了一种转换的方式
            return 1;
        }

        if (chars[idx] == '0') {
            //说明这种方式不可转换，直接返回0
            return 0;
        }

        if (chars[idx] == '1') {
            int p1 = process(chars, idx + 1);
            int p2 = 0;
            if ((idx + 1) < chars.length) {
                p2 = process(chars, idx + 2);
            }
            return p1 + p2;
        } else if (chars[idx] == '2') {
            int p1 = process(chars, idx + 1);
            int p2 = 0;
            if ((idx + 1) < chars.length && chars[idx+1] <= '6') {
                p2 = process(chars, idx + 2);
            }
            return p1 + p2;
        } else {
            //3以上只可能一个一个的转换。 因为字母就26个
            return process(chars, idx + 1);
        }

    }


    public static void main(String[] args) {
        System.out.println(new Code06_ConvertToLetterString().translateNum("101"));

    }

}
