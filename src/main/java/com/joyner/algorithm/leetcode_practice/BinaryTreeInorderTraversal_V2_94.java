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
public class BinaryTreeInorderTraversal_V2_94 {

    public List<Integer> inorderTraversalv1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        stack.add(root);

        while (!stack.isEmpty()) {
            if (root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                root.left = null;
                result.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                    root = root.right;
                }

            }
        }

        return result;


    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode curent = root;

        while (curent != null || !stack.isEmpty()) {
            while (curent != null) {
                stack.push(curent);
                curent = curent.left;
            }
            //开始弹
            curent = stack.pop();
            result.add(curent.val);
            //处理右边
            curent = curent.right;

        }

        return result;


    }

    public static void main(String[] args) {
        System.out.println();


        TreeNode temp = new TreeNode(2);
        TreeNode root = temp;
        temp = temp.left = new TreeNode(3);
        temp.left = new TreeNode(1);

        BinaryTreeInorderTraversal_V2_94 binaryTreeInorderTraversal_94 = new BinaryTreeInorderTraversal_V2_94();
        List<Integer> list = binaryTreeInorderTraversal_94.inorderTraversal(root);
        System.out.println(list);
    }
}
