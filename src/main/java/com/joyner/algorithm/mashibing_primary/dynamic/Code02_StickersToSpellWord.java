package com.joyner.algorithm.mashibing_primary.dynamic;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * 给定一个字符串str，给定一个字符串类型的数组arr。
 * arr里的每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来。
 * 返回需要至少多少张贴纸可以完成这个任务。
 * 例子：str= "babac"，arr = {"ba","c","abcd"}
 * 至少需要两张贴纸"ba"和"abcd"，因为使用这两张贴纸，把每一个字符单独剪开，含有2个a、2个b、1个c。是可以拼出str的。所以返回2。
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
public class Code02_StickersToSpellWord {

    /**
     * 第一张贴纸用谁来决定该算法。
     *
     * @param stickers
     * @param target
     * @return
     */
    public static int minStickers1(String[] stickers, String target) {
        if (stickers.length == 0 || StringUtils.isEmpty(target)) {
            //无效解
            return -1;
        }

        //贴纸的词频
        int[][] stickersFrequency = new int[stickers.length][26];
        //初始化
        for (int i = 0; i < stickersFrequency.length; i++) {
            String sticker = stickers[i];
            char[] chars = sticker.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                stickersFrequency[i][chars[j] - 'a']++;
            }
        }

        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        int r = process(dp, stickersFrequency, target);

        return r == Integer.MAX_VALUE ? -1 : r;
    }

    /**
     * 从第0张贴纸开始尝试，每张贴纸使用1到n次（直到不能用为止），往下尝试。最后取最小值
     *
     * @param rest
     * @return
     */
    private static int process(Map<String, Integer> dp, int[][] stickersFrequency, String rest) {
        if (dp.get(rest) != null) {
            return dp.get(rest);
        }
        // String str= "babac";
        //        String[] arr = {"abc","y","babac"};
        if (StringUtils.isEmpty(rest)) {
            //字符已经空，不需要在使用贴纸
            dp.put("", 0);
            return 0;
        }


        int result = Integer.MAX_VALUE;
        for (int i = 0; i < stickersFrequency.length; i++) {
            /**
             * 1.构造rest的词频
             * 2.获取卡片，如果卡片可以消掉一部分词频，则往下递归
             */
            String newRest = getNewRest(stickersFrequency[i], rest);
            if (!rest.equals(newRest)) {
                int r = process(dp, stickersFrequency, newRest);
                result = Math.min(1 + r, result);
            }
        }
        dp.put(rest, result);
        return result;
    }

    private static String getNewRest(int[] stickerFrequency, String rest) {
        //计算词频
        int[] restFrequency = new int[26];
        char[] chars = rest.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            restFrequency[chars[i] - 'a']++;
        }

        boolean isTrue = false;
        for (int i = 0; i < stickerFrequency.length; i++) {
            if (stickerFrequency[i] > 0 && restFrequency[i] > 0) {
                //消除词频
                restFrequency[i] = (restFrequency[i] - stickerFrequency[i]) < 0 ? 0 : (restFrequency[i] - stickerFrequency[i]);
                isTrue = true;
            }
        }

        if (!isTrue) {
            //不能消除
            return rest;
        }

        String newRest = "";
        for (int i = 0; i < restFrequency.length; i++) {
            while (restFrequency[i] > 0) {
                newRest += (char)('a' + i);
                restFrequency[i]--;
            }
        }
        return newRest;

    }


    public static void main(String[] args) {
        String str= "babac";
        String[] arr = {"x","y","z"};
        int i = minStickers1(arr, str);
        System.out.println(i);


    }


}
