package com.joyner.algorithm.leetcode_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
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
public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i =0; i < n; i++) {
            int temp = i + 1;
            if (temp % 3 == 0 && temp % 5 == 0) {
                result.add("FizzBuzz");
            } else if (temp % 3 == 0) {
                result.add("Fizz");
            } else if (temp % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add("" + temp);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        FizzBuzz_412 fizzBuzz_412 = new FizzBuzz_412();
        fizzBuzz_412.fizzBuzz(15);
    }
}
