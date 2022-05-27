package com.joyner.algorithm.search;

import com.joyner.common.util.collection.ArrUtils;
import org.apache.commons.lang3.StringUtils;

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
public class KMP_V3 {

    public static int[] getNext(String match) {
        if (StringUtils.isEmpty(match)) {
            throw new RuntimeException("match不允许为空");
        }
        if (match.length() == 1) {
            return new int[]{-1};
        }
        int[] next = new int[match.length()];

        next[0] = -1;
        next[1] = 0;
        //i-1位置的next信息
        int cn = 0;
        int i = 2;
        while (i < match.length()) {
            if (match.charAt(i - 1) == match.charAt(cn)) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                i++;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] next = getNext("abatabas");
        ArrUtils.printArr(next);
    }
}
