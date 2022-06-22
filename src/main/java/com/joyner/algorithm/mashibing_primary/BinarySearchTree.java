package com.joyner.algorithm.mashibing_primary;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  判断是否是一个二叉搜索树
 *  方法一
 *  1.对树进行中序遍历，如果是有序(升序)的，则一定是二叉搜索树
 *
 *  方法二
 *  1.以X为根的二叉搜索树满足
 *    1.1）左子树是二叉搜索树
 *    1.2）右子树是二叉搜索树
 *    1.3）max(左子树) < x && min(右子树) > x
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
public class BinarySearchTree {

    class Info {
        public boolean isBST;
        public int min;
        public int max;

        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }

    }

    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> middleTraversalResult = new ArrayList<>();

        middleTraversal(root, middleTraversalResult);

        boolean isSorted = isSorted(middleTraversalResult);
        return isSorted;
    }



    public boolean isBSTV2(TreeNode root) {
        Info info = isBSTHelper(root);
        return info.isBST;
    }



    private Info isBSTHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = isBSTHelper(root.left);
        Info rightInfo = isBSTHelper(root.right);


        boolean isBst = true;
        int min = rightInfo == null ? root.val : Math.min(root.val, rightInfo.min);
        int max = leftInfo == null ? root.val : Math.max(root.val, leftInfo.max);

        /**
         * 1.以X为根的二叉搜索树满足
         *     1.1）左子树是二叉搜索树
         *     1.2）右子树是二叉搜索树
         *     1.3）max(左子树) < x && min(右子树) > x
         */
        if (leftInfo != null && (leftInfo.max > root.val || !leftInfo.isBST)) {
            isBst = false;
        }

        if (rightInfo != null && (rightInfo.min < root.val || !rightInfo.isBST)) {
            isBst = false;
        }


        return new Info(isBst, min, max);



    }


    private boolean isSorted(List<Integer> middleTraversalResult) {
        for (int i = 0; i < middleTraversalResult.size() - 1; i++) {
            int val = middleTraversalResult.get(i);
            int nextVal = middleTraversalResult.get(i + 1);
            if (val > nextVal) {
                return false;
            }
        }
        return true;
    }

    private void middleTraversal(TreeNode root, List<Integer> middleTraversalResult) {

        if (root == null) {
            return;
        }
        middleTraversal(root.left, middleTraversalResult);
        middleTraversalResult.add(root.val);
        middleTraversal(root.right, middleTraversalResult);


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);


        BinarySearchTree binarySearchTree = new BinarySearchTree();
        boolean binarySearchTree1 = binarySearchTree.isBSTV2(root);
        System.out.println(binarySearchTree1);
    }

}
