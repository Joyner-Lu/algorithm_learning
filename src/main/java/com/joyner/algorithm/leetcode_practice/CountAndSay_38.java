package com.joyner.algorithm.leetcode_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
public class CountAndSay_38 {


    public String countAndSay(int n) {
        String init = "1";
        for (int i = 2; i <=n ; i++) {
            char[]  arr = init.toCharArray();
            char tempC = arr[0];
            int count = 0;
            String tempInit = "";
            for (int j = 0; j < init.length() ; j++) {
                if (tempC == arr[j]) {
                    count++;
                } else {
                    tempInit += count + "" + tempC;
                    //恢复
                    tempC = arr[j];
                    count = 1;
                }
            }
            tempInit += count + "" + tempC;
            init = tempInit;
        }
        return init;
    }

    public static void main(String[] args) {
        CountAndSay_38 countAndSay_38 = new CountAndSay_38();
        String r = countAndSay_38.countAndSay(4);
        System.out.println(r);
    }
}
