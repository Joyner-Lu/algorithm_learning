package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

/**
 * <pre>
 * 给定一棵二叉树的头节点head，返回这颗二叉树是不是搜索二叉树
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
public class IsSearchTree {

    class Info {
        int maxVal;
        int minVal;
        boolean isBST;
    }

    /**
     * 以X为头的节点是搜索二叉树的条件是：
     * 1.左树的最大值比X的值小
     * 2.右树的最小值比X的值大
     * 3.左右子树也必须事搜索二叉树 *********
     *
     * @param root
     * @return
     */
    public boolean isSearchTree(TreeNode root) {
        Info info = isSearchTreeHelp(root);
        return info.isBST;
    }

    private Info isSearchTreeHelp(TreeNode root) {
        if (root == null) {
            return null;
        }

        Info leftInfo = isSearchTreeHelp(root.left);
        Info rightInfo = isSearchTreeHelp(root.right);

        Info result = new Info();
        result.isBST = true;
        result.maxVal = root.val;
        result.minVal = root.val;

        //更新maxVal和minVal
        if (leftInfo != null) {
            result.maxVal = Math.max(leftInfo.maxVal, result.maxVal);
            result.minVal = Math.min(leftInfo.minVal, result.minVal);
        }

        if (rightInfo != null) {
            result.minVal = Math.min(rightInfo.minVal, result.minVal);
            result.maxVal = Math.max(rightInfo.maxVal, result.maxVal);
        }

        if (leftInfo != null && leftInfo.maxVal >= root.val) {
            result.isBST = false;
        }


        if (rightInfo != null && rightInfo.minVal <= root.val) {
            result.isBST = false;
        }


        if (leftInfo != null && !leftInfo.isBST) {
            result.isBST = false;
        }

        if (rightInfo != null && !rightInfo.isBST) {
            result.isBST = false;
        }

        return result;
    }

    public static void main(String[] args) {
        //[5,4,6,null,null,3,7]
        //[32,26,47,19,null,null,56,null,27]
        SerializeAndReconstructTreeLevel level = new SerializeAndReconstructTreeLevel();
        TreeNode root = level.unMasherTreeLevel("[5, 4, 7, 3, null, 2, null, -1, null, 9]");
        PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        printBinaryTree.print(root);
        IsSearchTree isSearchTree = new IsSearchTree();
        boolean searchTree = isSearchTree.isSearchTree(root);



        System.out.println(searchTree);
    }

}
