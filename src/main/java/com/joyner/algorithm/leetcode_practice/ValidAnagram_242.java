package com.joyner.algorithm.leetcode_practice;

import java.util.Arrays;
import java.util.HashMap;
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
public class ValidAnagram_242 {

    HashMap<Character, Integer> letterCountOne = new HashMap();
    HashMap<Character, Integer> letterCountTwo = new HashMap();

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        setLetterCount(s, letterCountOne);
        setLetterCount(t, letterCountTwo);
        Set<Character> keySet = letterCountOne.keySet();
        for(char c : keySet) {
            if (letterCountTwo.get(c) == null || !letterCountTwo.get(c).equals(letterCountOne.get(c))) {
                //不存在或者数量不一致返回false
                return false;
            }

        }

        return true;
    }

    public boolean isAnagramv2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    private boolean setLetterCount(String s, HashMap<Character,Integer> letterCount) {
        for (char c: s.toCharArray()) {
            Integer count = letterCount.get(c);
            if (count == null) {
                letterCount.put(c, 1);
            } else {
                letterCount.put(c, count + 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "test";
        String t = "test";
        ValidAnagram_242 validAnagram_242 = new ValidAnagram_242();
        boolean r = validAnagram_242.isAnagram(s, t);
        System.out.println(r);
    }

}
