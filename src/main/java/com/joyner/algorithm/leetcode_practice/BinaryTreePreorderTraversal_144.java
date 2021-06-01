package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;
import com.joyner.common.util.collection.ListUtil;

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
public class BinaryTreePreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {

            if (current != null) {
                stack.push(current);
                result.add(current.val);
                current = current.left;
            } else {
                //指向右节点
                current = stack.pop();
                current = current.right;
            }
        }
        return result;

    }


    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        preorderTraversalHelp(root, result);
        return result;
    }

    private void preorderTraversalHelp(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalHelp(root.left, result);
        preorderTraversalHelp(root.right, result);

    }

    public static void main(String[] args) {
        TreeNode temp = new TreeNode(1);
        TreeNode root = temp;
        temp = temp.right = new TreeNode(2);
        temp.left = new TreeNode(3);
        BinaryTreePreorderTraversal_144 binaryTreePreorderTraversal_144 = new BinaryTreePreorderTraversal_144();
        List<Integer> integers = binaryTreePreorderTraversal_144.preorderTraversal(root);
        ListUtil.printV2(integers);


        List<Integer> integers1 = binaryTreePreorderTraversal_144.preorderTraversalV2(root);
        ListUtil.printV2(integers1);

    }
}
