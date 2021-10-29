package com.joyner.algorithm.mashibing_primary.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 *给定一个由字符串组成的数组strs，
 * 必须把所有的字符串拼接起来，
 * 返回所有可能的拼接结果中，字典序最小的结果
 *
 * 备注：所谓的字典序定义如下，
 * 1.如果两个字符串长度相同，那么逐位比较，谁小谁放后面。 例如： abc  abs则abc放前面，abs放后面
 * 2.如果两个字符串长度不相同，短的字符串补零， acyst， 和b 变成 acyst 和 b0000   开始比高位， b比a大，所以必然 b放在前面
 *
 * 字符串认为就是k进制的整数，例如 a-z，26进制,如果长度一样，则比数值。长度不一样，则比高位。
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
public class LowestLexicography {

    /**
     * 使用全排列，复杂度n的阶乘
     *
     * @param strs
     * @return
     */
    public static String lowestStringV1(String[] strs) {
        List<String> all = new ArrayList<>();
        boolean[] use = new boolean[strs.length];
        String path = "";
        process(strs, use, path, all, 0);

        all.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });


        return all.get(0);

    }


    public static String lowestStringV2(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            result += strs[i];
        }
        return result;
    }

    private static void process(String[] strs, boolean[] use , String path, List<String> all, int idx) {
        if (idx == strs.length) {
            all.add(path);
        } else {
            for (int i = 0; i < strs.length; i++) {
                if (!use[i]) {
                    use[i] = true;
                    process(strs, use, path  + strs[i], all, idx + 1);
                    use[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        String[] strs = {"ba", "b"};
        String s = lowestStringV1(strs);
        System.out.println(s);
        System.out.println(lowestStringV2(strs));
    }
}
