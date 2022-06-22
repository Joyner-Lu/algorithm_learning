package com.joyner.algorithm.leetcode_practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * 使用广度（宽度）优先遍历
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
public class Permutations_bfs_46 {



    /**
     * 全排列可以想象成一课树。[1,2,3]如下图示：<br>
     *     队列如下：
     *  ------------------------------------->
     *  [3-2 3-1  2-3  2-1  1-3  1-2]-第二层 [3 2 1]-第一层
     *  ------------------------------------->
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            queue.offer(num + "");
        }

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            String[] split = poll.split("###");
            if (split.length == nums.length) {
                //结果
                List<Integer> r = new ArrayList<>();
                for (int i = 0; i < split.length; i++) {
                    r.add(Integer.valueOf(split[i]));
                }
                ans.add(r);
                //System.out.println(poll);
            } else {
                for (int i = 0; i < nums.length; i++) {
                    int num = nums[i];
                    boolean isContain = isContain(num, split);
                    if (!isContain) {
                        queue.offer(poll + "###" + num);
                    }
                }
            }


        }


        return ans;

    }

    private boolean isContain(int num, String[] split) {
        for (int i = 0; i < split.length; i++) {
            Integer val = Integer.valueOf(split[i]);
            if (val == num) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations_bfs_46 permutations_bfs_46 = new Permutations_bfs_46();
        permutations_bfs_46.permute(nums);
    }
}
