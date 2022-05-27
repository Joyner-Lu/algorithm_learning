package com.joyner.algorithm.mashibing_primary.dynamic;

import com.joyner.common.util.collection.ArrUtils;
import com.joyner.common.util.collection.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 *
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
public class PrintAllPermutations {

    public static List<String> permutation(String str) {
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        boolean[] used = new boolean[chars.length];
        String path = "";
        permutationHelp(chars, result, used, path);
        return result;
    }

    private static void permutationHelp(char[] chars, List<String> result, boolean[] used, String path) {
        if (path.length() == chars.length) {
            result.add(path);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutationHelp(chars, result, used, path + chars[i]);
                used[i] = false;
            }
        }
    }


    public static List<String> permutationV2(String str) {
        char[] chars = str.toCharArray();
        List<String> result = new ArrayList<>();
        //当前固定的位置
        int fixPosition = 0;
        permutationHelpV2(chars, result, fixPosition);
        return result;
    }


    private static void permutationHelpV2(char[] chars, List<String> result,int fixPosition) {
        if (fixPosition == chars.length) {
            String str = "";
            for (int i = 0; i < chars.length; i++) {
                str += (chars[i] + "");
            }
            result.add(str);
            return;
        }
        for (int i = fixPosition; i < chars.length; i++) {
            ArrUtils.swapCharArr(chars, i, fixPosition);
            permutationHelpV2(chars, result, fixPosition + 1);
            //恢复现场
            ArrUtils.swapCharArr(chars, i, fixPosition);
        }
    }

    public static Set<String> permutationV1NoRepeat(String str) {
        char[] chars = str.toCharArray();
        Set<String> result = new HashSet<>();
        //当前固定的位置
        int fixPosition = 0;
        permutationV1NoRepeatHelp(chars, result, fixPosition);
        return result;
    }

    private static void permutationV1NoRepeatHelp(char[] chars, Set<String> result, int fixPosition) {
        if (fixPosition == chars.length) {
            String str = "";
            for (int i = 0; i < chars.length; i++) {
                str += (chars[i] + "");
            }
            result.add(str);
            return;
        }
        for (int i = fixPosition; i < chars.length; i++) {
            ArrUtils.swapCharArr(chars, i, fixPosition);
            permutationV1NoRepeatHelp(chars, result, fixPosition + 1);
            //恢复现场
            ArrUtils.swapCharArr(chars, i, fixPosition);
        }
    }

    public static List<String> permutationV2NoRepeat(String str) {
        char[] chars = str.toCharArray();
        List<String> result = new ArrayList<>();
        //当前固定的位置
        int fixPosition = 0;
        permutationV2NoRepeatHelp(chars, result, fixPosition);
        return result;
    }

    private static void permutationV2NoRepeatHelp(char[] chars, List<String> result, int fixPosition) {
        if (fixPosition == chars.length) {
            String str = "";
            for (int i = 0; i < chars.length; i++) {
                str += (chars[i] + "");
            }
            result.add(str);
            return;
        }
        boolean[] visited = new boolean[26];
        for (int i = fixPosition; i < chars.length; i++) {
            if (!visited[chars[i] - 'a']) {
                visited[chars[i] - 'a'] = true;
                ArrUtils.swapCharArr(chars, i, fixPosition);
                permutationV2NoRepeatHelp(chars, result, fixPosition + 1);
                //恢复现场
                ArrUtils.swapCharArr(chars, i, fixPosition);
            }

        }
    }


    public static void main(String[] args) {
        List<String> result = permutationV2NoRepeat("aaa");
        for(String str : result) {
            System.out.println(str);
        }
    }
}
