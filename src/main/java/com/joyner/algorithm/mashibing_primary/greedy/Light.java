package com.joyner.algorithm.mashibing_primary.greedy;

import com.joyner.algorithm.mashibing_primary.tree.MaxDistance;

import java.util.HashSet;

/**
 * <pre>
 * 给定一个字符串str，只由‘X’和‘.’两种字符构成。
 * ‘X’表示墙，不能放灯，也不需要点亮
 * ‘.’表示居民点，可以放灯，需要点亮
 * 如果灯放在i位置，可以让i-1，i和i+1三个位置被点亮
 * 返回如果点亮str中所有需要点亮的位置，至少需要几盏灯
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
public class Light {

    /**
     * 使用暴力解
     *
     * @param road
     * @return
     */
    public static int minLight1(String road) {
        if (road == null  || "".equals(road)) {
            return 0;
        }
        char[] chars = road.toCharArray();
        int min = process(chars, 0, new HashSet<Integer>());
        return min;

    }

    /**
     *
     * XX..XX..XXXX.XXX.
     * 使用贪心策略。来的第i步做如下选择
     * 1.如果i位置的值为x,则不放灯，进入下一个位置
     * 2.如果i位置的值为., 则
     *   2.1 i+1位置为点，则放入灯，i调到i+3的位置
     *   2.2 i+1的位置为x,则i放入灯，i进入i+2的位置。
     *
     * @param road
     * @return
     */
    public static int minLight2(String road) {
        if (road == null  || "".equals(road)) {
            return 0;
        }
        char[] chars = road.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                result++;
                if (i == chars.length -1) {
                    break;
                }
                if (chars[i + 1] == '.') {
                    //减1 的原因是：for循环里面有++
                    i = i + 3 - 1;
                } else {
                    //减1 的原因是：for循环里面有++
                    i = i + 2 - 1;
                }
            }
        }
        return result;

    }

    /**
     * 全排列解法
     *
     * @param chars
     * @param idx
     * @param lights 放置灯的集合，存的是下标，如果某个下标放到了lights,则表明该位置放灯，否则不放灯。
     * @return
     */
    private static int process(char[] chars, int idx, HashSet<Integer> lights) {
        if(idx == chars.length) {
           /* for (int i = 0; i < chars.length; i++) {
                if (lights.contains(i)) {
                    System.out.print("v");
                } else {
                    System.out.print("x");
                }
            }
            System.out.println();*/

            //表明我已经弄完了。
            for (int i = 0; i < chars.length; i++) {
                if ('.' == chars[i]) {
                    //判断，当前的是否放灯，如果不放灯，则判断i -1的点是否放灯，如果还是么有，则判断i+1的点是否放灯，如果都没有返回最大值。
                    //表明不可能被照亮，此时lights收集的一定是错的。
                    if (!lights.contains(i) && !lights.contains(i - 1) && !lights.contains(i + 1)) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            //满足则返回放灯的数量
            return lights.size();
        } else {
            //1.当前步骤不放灯
            int no = process(chars, idx + 1, lights);

            int yes = Integer.MAX_VALUE;
            if (chars[idx] == '.') {
                lights.add(idx);
                //2.当前步骤放灯
                yes = process(chars, idx + 1, lights);
                lights.remove(idx);
            }
            int result = Math.min(no, yes);
            return result;
        }
    }

    public static void main(String[] args) {
        String s = "XX..XX..XXXX.XXX.";
        int i = minLight1(s);
        System.out.println(i);

        int i1 = minLight2(s);
        System.out.println(i1);
    }
}
