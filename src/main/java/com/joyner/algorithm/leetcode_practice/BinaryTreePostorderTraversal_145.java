package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;
import com.joyner.common.util.collection.ListUtil;
import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

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
public class BinaryTreePostorderTraversal_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        TreeNode prev = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (current.right == null || current.right == prev) {
                result.add(current.val);
                prev = current;
                current = null;
            } else {
                stack.push(current);
                current = current.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode temp = new TreeNode(1);
        TreeNode root = temp;
        temp = temp.right = new TreeNode(2);
        temp.left = new TreeNode(3);
        BinaryTreePostorderTraversal_145 binaryTreePostorderTraversal_145 = new BinaryTreePostorderTraversal_145();
        List<Integer> integers = binaryTreePostorderTraversal_145.postorderTraversal(root);
        ListUtil.printV2(integers);
    }
}
