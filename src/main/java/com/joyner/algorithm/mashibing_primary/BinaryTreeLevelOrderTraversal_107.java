package com.joyner.algorithm.mashibing_primary;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;
import com.joyner.common.util.collection.ArrUtils;
import com.joyner.common.util.collection.ListUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 使用队列来完成。
 * 1.根进入队列，
 * 2.获取队列的size,取出来放入结果，获取左右孩子放入队列，
 * 3.获取队列的size,每取出来一个就放入接口，且把其孩子入队。当取完长度为size的节点的时候。收集结果完毕。
 * 4.重复。
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
public class BinaryTreeLevelOrderTraversal_107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            //构造List
            List<Integer> cur = new ArrayList<>();
            while (size > 0) {
                //出队
                TreeNode node = queue.poll();
                cur.add(node.val);
                size--;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.addFirst(cur);

        }

        return ans;
    }

    public static void main(String[] args) {
        int maxLen = 20;
        int maxVal = 50;
        TreeNode root = RandomGenerator.generateRandomTree(maxLen, maxVal);

        BinaryTreeLevelOrderTraversal_107 binaryTreeLevelOrderTraversal_107 = new BinaryTreeLevelOrderTraversal_107();
        List<List<Integer>> result = binaryTreeLevelOrderTraversal_107.levelOrderBottom(root);
        ListUtil.print(result);
    }
}
