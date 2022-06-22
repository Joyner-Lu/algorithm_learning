package com.joyner.algorithm.search;


import com.joyner.common.util.collection.ArrUtils;

import java.util.Arrays;

/**
 * <pre>
 * KMP算法，模式匹配串算法
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
public class KMP_V2 {


    public int indexOf(String str, String subStr) {
        int[] next = getNext(subStr);
        int result = -1;
        int subLen = subStr.length();
        int subPos = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            out:for(;subPos < subLen;) {
                char subC = subStr.charAt(subPos);
                while (c != subC) {
                    subPos = next[subPos + 1];
                    if (subPos == 0) {
                        //1号位与主串下一位进行比较
                        break out;
                    }
                    subC = subStr.charAt(--subPos);
                }
                subPos++;
                //继续下一位的比较
                break;
            }
            if (subPos == subLen) {
                result = i - subPos + 1;
                break;
            }
        }

        return result;

    }


    /**
     * 求解next数组
     *
     * @return
     */
    public int[] getNext(String subStr) {
        int[] next = new int[subStr.length() + 1];
        int j = 0;
        int t = 0;
        //第0位不用
        next[j++] = -1;
        //公共串位 t-1
        next[j] = t;
        //这里是求j++,因此是：next.length - 1
        while (j < next.length - 1) {
            //这里都要减一，因为next长度大于subStr，且第一位是不用的，所以需要减1
            if (t == 0 || subStr.charAt(j - 1) == subStr.charAt(t - 1)) {
                //t如果等与0，那么next[j+1] = 1.同样也是++t;
                next[++j] = ++t;
            } else {
                t = next[t];
            }
        }

        return next;
    }

    public static void main(String[] args) {
        KMP_V2 kmp_v2 = new KMP_V2();
        int[] next = kmp_v2.getNext("ABABAAABABAA");
        ArrUtils.printArr(next);

        int i = kmp_v2.indexOf("fababdfsababcttt", "ttt");
        System.out.println(i);
    }

}
