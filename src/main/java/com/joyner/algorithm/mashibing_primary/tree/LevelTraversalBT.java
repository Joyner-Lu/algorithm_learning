package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <pre>
 * 按层遍历树
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
public class LevelTraversalBT {

    /**
     * 使用map来实现，map： key: treeNode, val: level  记录节点属于那一层
     *
     * @param root
     */
    public void level(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " ");
            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(10);

        root.right.left = new TreeNode(3);

        LevelTraversalBT levelTraversalBT = new LevelTraversalBT();
        levelTraversalBT.level(root);
    }

}
