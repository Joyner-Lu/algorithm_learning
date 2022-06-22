package com.joyner.algorithm.leetcode_practice;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * <pre>
 * 状态：每个节点表示了求解问题的不同阶段
 * 例如：[2, 1]可以表示第一个位置元素是2，第一个元素是1这个阶段下，继续搜索第3个位置的值，也可以第3个位置的节点考虑完了回到上一个节点
 *
 * 状态重置
 * 在回到上一个节点的时候，撤销对上一次的选择，也就是保持和刚刚进来的一致
 *
 * ****树形问题上的深度优先遍历就是大名鼎鼎的回溯算法
 *
 * 这里的状态重置是回溯的意思
 *
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
public class Permutations_dfsv2_46 {

    /**
     * 递归实现
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth++, path, used, res);
            path.removeLast();
            used[i] = false;
        }


    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations_dfsv2_46 permutations_46 = new Permutations_dfsv2_46();
        List<List<Integer>> res = permutations_46.permute(nums);
        System.out.println();
    }
}
