package com.joyner.algorithm.leetcode_practice;

import java.util.HashMap;
import java.util.Map;

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
public class RomanToInteger_13 {

    private Map<Character, Integer> romanNumDict = new HashMap<>();

    public int romanToInt(String s) {
        initDict();

        int sum = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char romanC = arr[i];

            //处理特殊规则
            //I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
            //X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
            //C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
            if (i < arr.length -1 && romanC == 'I' && (arr[i+1] == 'V' || arr[i+1] == 'X')) {
                sum += romanNumDict.get(arr[i+1]) - romanNumDict.get(romanC);
                i++;
            } else if (i < arr.length -1 && romanC == 'X' && (arr[i+1] == 'L' || arr[i+1] == 'C')) {
                sum += romanNumDict.get(arr[i+1]) - romanNumDict.get(romanC);
                i++;
            } else if (i < arr.length -1 && romanC == 'C' && (arr[i+1] == 'D' || arr[i+1] == 'M')) {
                sum += romanNumDict.get(arr[i+1]) - romanNumDict.get(romanC);
                i++;
            }  else {
                sum += romanNumDict.get(romanC);
            }

        }

        return sum;
    }

    private void initDict() {
        romanNumDict.put('I', 1);
        romanNumDict.put('V', 5);
        romanNumDict.put('X', 10);
        romanNumDict.put('L', 50);
        romanNumDict.put('C', 100);
        romanNumDict.put('D', 500);
        romanNumDict.put('M', 1000);
    }

    public static void main(String[] args) {
        RomanToInteger_13 romanToInteger_13 = new RomanToInteger_13();
        int r = romanToInteger_13.romanToInt("IV");
        System.out.println(r);
    }
}
