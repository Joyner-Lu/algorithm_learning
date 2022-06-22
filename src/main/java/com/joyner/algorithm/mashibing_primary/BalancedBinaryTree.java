package com.joyner.algorithm.mashibing_primary;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

/**
 * <pre>
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 判断以root为根的树是否是完全平衡二叉树
 * 1）root的左子树是完全平衡二叉树
 * 2）root的右子树是完全平衡二叉树
 * 3）root的左子树高度-root的右子树高度 <=1
 *
 * 如此反复这个过程
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
public class BalancedBinaryTree {

    class Info {
        public int height = 0;
        public boolean isBalanced = false;
        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }


    public boolean isBalanced(TreeNode root) {
        Info info = isBalancedHelper(root);
        return info.isBalanced;

    }

    private Info isBalancedHelper(TreeNode root) {
        if (root == null) {
            //一视同仁，所有的都返回自己是否平衡树以及自身高度
            //也就是空节点，一定是平衡的，且高度是0
            return new Info(0, true);
        }

        Info leftInfo = isBalancedHelper(root.left);
        Info rightInfo = isBalancedHelper(root.right);

        //计算自己的高度
        //为前一个节点的高度加1
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        //判断自己是否平衡的条件
        //计算高度差
        int heightVaries = Math.abs(leftInfo.height - rightInfo.height);
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && heightVaries < 2;

        Info info = new Info(height, isBalanced);
        return info;

    }


}
