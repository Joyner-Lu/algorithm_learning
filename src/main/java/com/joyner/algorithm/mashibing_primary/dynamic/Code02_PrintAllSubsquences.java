package com.joyner.algorithm.mashibing_primary.dynamic;

import com.joyner.common.util.collection.ArrUtils;
import com.joyner.common.util.collection.ListUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * 子序列就是字符串的子串，但是要求相对次序不能乱。
 * 例如：abc ab ac bc c
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
public class Code02_PrintAllSubsquences {

    public List<String> subs(String str) {
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        subsHelp(chars, result, 0, "");
        return result;
    }

    public Set<String> subsNoRepeat(String str) {
        Set<String> result = new HashSet<>();
        char[] chars = str.toCharArray();
        subsHelpV2(chars, result, 0, "");
        return result;
    }

    private void subsHelpV2(char[] chars, Set<String> set, int idx, String path) {
        if (idx == chars.length) {
            if (StringUtils.isNotEmpty(path)) {
                set.add(path);
            }
            return;
        }
        String no = path;
        subsHelpV2(chars, set, idx + 1, no);
        String yes = (path + chars[idx]);
        subsHelpV2(chars, set, idx + 1, yes);
    }

    private void subsHelp(char[] chars, List<String> result, int idx, String path) {
        if (idx == chars.length) {
            if (StringUtils.isNotEmpty(path)) {
                result.add(path);
            }
            return;
        }
        String no = path;
        subsHelp(chars, result, idx + 1, no);
        String yes = (path + chars[idx]);
        subsHelp(chars, result, idx + 1, yes);

    }


    public static void main(String[] args) {
        Code02_PrintAllSubsquences code02_printAllSubsquences = new Code02_PrintAllSubsquences();
        List<String> result = code02_printAllSubsquences.subs("aaa");
        System.out.println();
        ListUtil.commonPrint(result);


        Set<String> abc = code02_printAllSubsquences.subsNoRepeat("aaa");
        System.out.println();

    }

}
