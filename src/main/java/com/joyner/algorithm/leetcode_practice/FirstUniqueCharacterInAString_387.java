package com.joyner.algorithm.leetcode_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
public class FirstUniqueCharacterInAString_387 {

    private Map<Character, Integer> idxMap = new HashMap<>();

    public int firstUniqChar(String s) {
        int norepeatIdx = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = idxMap.get(c);
            if (count == null) {
                count = 0;
                idxMap.put(c, i);
            } else {
                idxMap.put(c, 999);//重复999
            }
        }
        Set<Map.Entry<Character, Integer>> entries = idxMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (!entry.getValue().equals(999) && entry.getValue() < norepeatIdx) {
                norepeatIdx = entry.getValue();
            }
        }

        return norepeatIdx == Integer.MAX_VALUE ? -1 : norepeatIdx ;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString_387 firstUniqueCharacterInAString_387 = new FirstUniqueCharacterInAString_387();
        String s = "eessee";
        int r = firstUniqueCharacterInAString_387.firstUniqChar(s);
        System.out.println(r);
    }
}
