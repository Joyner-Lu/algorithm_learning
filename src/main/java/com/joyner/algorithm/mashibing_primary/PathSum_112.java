package com.joyner.algorithm.mashibing_primary;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

/**
 * <pre>
 * https://leetcode-cn.com/problems/path-sum/
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
public class PathSum_112 {


    public boolean result = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int preSum = 0;
        hasPathSumHelper(root, preSum, targetSum);
        return result;
    }



    private void hasPathSumHelper(TreeNode root, int preSum, int targetSum) {
        preSum += root.val;
        if (root.left == null && root.right == null) {
            //当前是叶子节点
            result = (preSum == targetSum);
            return;
        }

        //满足了就不要往下继续了
        if (root.left != null && !result) {
            hasPathSumHelper(root.left, preSum, targetSum);
        }
        if (root.right != null && !result) {
            hasPathSumHelper(root.right, preSum, targetSum);
        }

    }

    public static void main(String[] args) {
        int targetSum = -1;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);




        PathSum_112 pathSum_112 = new PathSum_112();
        boolean b = pathSum_112.hasPathSum(root, targetSum);
        System.out.println(b);
    }
}
