package com.joyner.algorithm.leetcode_practice;


import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5

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
public class ConvertSortedArrayToBinarySearchTree_108 {

    /**
     * 时间复杂度：O(n)O(n)，其中 nn 是数组的长度。每个数字只访问一次。
     *
     * 空间复杂度：O(\log n)O(logn)，其中 nn 是数组的长度。空间复杂度不考虑返回值，因此空间复杂度主要取决于递归栈的深度，递归栈的深度是 O(\log n)O(logn)。
     *

     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    private void insertNode(TreeNode root, TreeNode treeNode) {
        if (treeNode.val < root.val) {
            //left
            if (root.left != null) {
                insertNode(root.left, treeNode);
            } else {
                root.left = treeNode;
            }
        } else {
            //right
            if (root.right != null) {
                insertNode(root.right, treeNode);
            } else {
                root.right = treeNode;
            }
        }
        
        int deep = checkDeep(root);

    }

    private int checkDeep(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root.left);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return 0;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree_108 c = new ConvertSortedArrayToBinarySearchTree_108();
        int[] arr = {-10,-3,0,5,9};
        TreeNode root = c.sortedArrayToBST(arr);
        System.out.println();
    }
}
