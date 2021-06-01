package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class BinaryTreeInorderTraversal_94 {



    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    /**
     * 中序遍历（LDR）是二叉树遍历的一种，也叫做中根遍历、中序周游。在二叉树中，中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalv1(TreeNode root) {
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            inorderTraversalv1(root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inorderTraversalv1(root.right);
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            if (root.left != null) {
                //1处
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                root.left = null;//把left置空，否则1处回溯的时候会误判
                result.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                    root = root.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println();


        TreeNode temp = new TreeNode(2);
        TreeNode root = temp;
        temp = temp.left = new TreeNode(3);
        temp.left = new TreeNode(1);

        BinaryTreeInorderTraversal_94 binaryTreeInorderTraversal_94 = new BinaryTreeInorderTraversal_94();
        List<Integer> list = binaryTreeInorderTraversal_94.inorderTraversal(root);
        System.out.println(list);
    }
}
