package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

/**
 * <pre>
 * 给定一棵二叉树的头节点head，任何两个节点之间都存在距离，
 * 返回整棵二叉树的最大距离
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
public class MaxDistance {


    class Info {
        int maxDistance;
        int height;
    }



    /**
     * 以X为头的节点的最大距离是
     * 1.经过X，那么最大的距离是，左树的高度+右树的高度+1
     * 2.不经过X
     *   对左树的最大距离和右树的最大距离取最大值，返回。
     *
     * @param root
     * @return
     */
    public int maxDistance(TreeNode root) {

        Info info = maxDistanceHelp(root);
        return info.maxDistance;
    }

    private Info maxDistanceHelp(TreeNode root) {
        if (root == null) {
            Info info = new Info();
            info.maxDistance = 0;
            info.height = 0;
            return info;
        }

        //处理左树
        Info leftInfo = maxDistanceHelp(root.left);
        Info rightInfo = maxDistanceHelp(root.right);

        Info result = new Info();
        result.height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int throughXDistance = leftInfo.height + rightInfo.height + 1;
        int noThroughXDistance = Math.max(leftInfo.maxDistance, rightInfo.maxDistance);
        if (throughXDistance >= noThroughXDistance) {
            result.maxDistance = throughXDistance;
        } else {
            result.maxDistance = noThroughXDistance;
        }
        return result;

    }

    public static void main(String[] args) {
        MaxDistance maxDistance = new MaxDistance();
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = MaxDistanceTest.generateRandomBST(maxLevel, maxValue);
            if (MaxDistanceTest.maxDistance1(head) != MaxDistanceTest.maxDistance2(head)) {
                System.out.println("Oops!");
            }
            int i1 = maxDistance.maxDistance(head);
            if (i1 != MaxDistanceTest.maxDistance1(head)) {
                throw new RuntimeException("fuck");
            }
        }
        System.out.println("finish!");
    }
}
