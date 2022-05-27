package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class CompleteTree_958 {

    /**
     * 使用层级遍历
     * 1.如果一个节点有右孩子，则必然不是完全二叉树
     * 2.如果一个节点不完全，则剩下的节点，必须都是叶子节点
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean mustLeaf = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.right != null && poll.left == null) {
                return false;
            }

            if (mustLeaf && (poll.left != null || poll.right != null)) {
                return false;
            }

            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            } else {
                mustLeaf = true;
            }

        }

        return true;
    }
}
