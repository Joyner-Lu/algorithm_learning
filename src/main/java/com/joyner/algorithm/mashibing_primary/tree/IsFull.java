package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

/**
 * <pre>
 * 给定一棵二叉树的头节点head，返回这颗二叉树是不是满二叉树<br>
 *     满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
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
public class IsFull {

    class Info {
        boolean isFull;
        public Info(boolean isFull) {
            this.isFull = isFull;
        }
    }

    /**
     * 以x为头的节点是否是满二叉树要满足如下条件
     * 1.x孩子的节点数不能为1
     * 2.x的左孩子是满二叉树且x的右孩子是满二叉树
     * @param root
     * @return
     */
    public boolean isFull(TreeNode root) {
        Info info = isFullHelp(root);
        return info.isFull;
    }

    private Info isFullHelp(TreeNode root) {
        if (root == null) {
            return new Info(true);
        }
        int childSize = 0;
        if (root.left != null) {
            childSize++;
        }
        if (root.right != null) {
            childSize++;
        }
        if (childSize == 1) {
            return new Info(false);
        }

        Info leftInfo = isFullHelp(root.left);
        Info rightInfo = isFullHelp(root.right);
        Info info = new Info(false);
        if (leftInfo.isFull && rightInfo.isFull) {
            info.isFull = true;
        }

        return info;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);



        IsFull isFull = new IsFull();
        boolean full = isFull.isFull(root);
        System.out.println(full);
    }
}
