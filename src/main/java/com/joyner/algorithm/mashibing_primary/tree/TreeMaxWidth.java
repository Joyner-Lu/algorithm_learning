package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
public class TreeMaxWidth {

    /**
     * 使用map来记录，当前节点属于那一层。
     *
     * @param root
     */
    public int maxWidthUseMap(TreeNode root) {
        Map<TreeNode, Integer> levelMap = new HashMap();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        levelMap.put(root, 1);
        //当前层的节点数
        int currLevelNodes = 0;
        //开始处于第一层
        int level = 1;
        int max = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            //获取层树
            Integer l = levelMap.get(poll);
            if (poll.left != null) {
                queue.offer(poll.left);
                levelMap.put(poll.left, l + 1);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
                levelMap.put(poll.right, l + 1);
            }

            if (l.equals(level)) {
                currLevelNodes++;
            } else {
                //更新max
                max = Math.max(currLevelNodes, max);
                //到下一层(第一层第一次会消耗一个节点)。
                currLevelNodes = 1;
                level++;
            }
        }

        //最后一层也要更新
        max = Math.max(currLevelNodes, max);

        return max;


    }

    /**
     * 分配两个指针，一个是 curLevelEnd，一个是 nextLevelEnd
     * 1.开开始curLevelEnd执行root, nextLevelEnd指向null，root放入队列
     * 2.队列非空，取出队列的节点，如果左孩子不为空，nextLevelEnd指向左孩子，累加节点数，右孩子不为空，nextLevelEnd指向右孩子，
     * 判断取出的节点是否等于curLevelEnd，如果 等于更新max的值，然后nextLevelEnd赋值给curLevelEnd， nextLevelEnd继续按照第2步来进行变化。
     *
     * 备注：curLevelEnd用于占住当前结尾的位置。  nextLevelEnd用于跟踪下一层结尾的位置。
     *
     * @param root
     */
    public int maxWidthNoMap(TreeNode root) {
        TreeNode currEnd = root;
        TreeNode nextEnd = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currLevelNodes = 1;
        int max = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                nextEnd = poll.left;
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                nextEnd = poll.right;
                queue.offer(poll.right);
            }

            if (!poll.equals(currEnd)) {
                currLevelNodes++;
            } else {
                //到下一层
                max = Math.max(currLevelNodes, max);
                currEnd = nextEnd;
                nextEnd = null;
                currLevelNodes = 1;
            }
        }
        return max;


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(10);

        root.right.left = new TreeNode(3);

        TreeMaxWidth treeMaxWidth = new TreeMaxWidth();
        int i = treeMaxWidth.maxWidthUseMap(root);
        System.out.println(i);
        int s = treeMaxWidth.maxWidthNoMap(root);
        System.out.println(s);
    }
}
