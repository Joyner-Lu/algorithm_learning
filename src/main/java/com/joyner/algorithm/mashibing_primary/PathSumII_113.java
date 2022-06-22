package com.joyner.algorithm.mashibing_primary;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
public class PathSumII_113 {


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> cur = new ArrayList<>();
        int preSum = 0;
        pathSumHelper(root, ans, cur, preSum, targetSum);

        return ans;
    }

    private void pathSumHelper(TreeNode root, List<List<Integer>> ans, List<Integer> cur,int preSum, int targetSum) {
        preSum += root.val;
        //添加结果
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == preSum) {
                //收集到目标
                ans.add(copy(cur));
                //收集完毕，移除最后一个。
                cur.remove(cur.size() - 1);
            }
        }

        if (root.left != null) {
            pathSumHelper(root.left, ans, cur, preSum, targetSum);
        }

        if (root.right != null) {
            pathSumHelper(root.right, ans, cur, preSum, targetSum);
        }

        //返回之前，把当前层的最后一个元素移除掉。
        cur.remove(cur.size() -1);



    }

    public static List<Integer> copy(List<Integer> list) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ans.add(list.get(i));
        }
        return ans;
    }
}
