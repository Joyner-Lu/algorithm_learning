package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

/**
 * <pre>
 * 给定一棵二叉树的头节点head，
 * 返回这颗二叉树中最大的二叉搜索子树的头节点
 *
 * 注意这里的最大就是节点最多的二叉搜索树
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
public class MaxSubBSTHead {

    class Info {
        TreeNode head;
        boolean isBST;
        int max;
        int min;
        int maxSize;
    }

    /**
     * 以X未头的节点，找最大二叉搜索树的头节点
     * 1.如果以X为头的就是二叉搜索树，则头节点就是X<br>
     *     前提：左子树是二叉搜索树，有子树也是二叉搜索树，且左子树的最大值小于x，右子树的最小值大于x
     * 2.如果x为头的不是二叉搜索树，则pk则子树的maxSize和右子树的maxSize，谁大拿谁的head
     *
     * @param root
     * @return
     */
    public TreeNode maxSubBSTHead(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info info = maxSubBSTHeadHelp(root);
        return info.head;
    }

    private Info maxSubBSTHeadHelp(TreeNode root) {
        if (root == null) {
            return null;
        }
        //1.处理左子树
        //2.处理右子树
        Info leftInfo = maxSubBSTHeadHelp(root.left);
        Info rightInfo = maxSubBSTHeadHelp(root.right);

        Info info = new Info();
        info.max = root.val;
        info.min = root.val;
        info.isBST = false;

        //3.更新min和max
        if (leftInfo != null) {
            info.max = Math.max(leftInfo.max, info.max);
            info.min = Math.min(leftInfo.min, info.min);

        }

        if (rightInfo != null) {
            info.max = Math.max(rightInfo.max, info.max);
            info.min = Math.min(rightInfo.min, info.min);
        }

        //4.更新isBST
        boolean isLeftBST = leftInfo == null ? true : leftInfo.isBST;
        boolean isRightBST = rightInfo == null ? true : rightInfo.isBST;
        boolean isMaxValOfLeftLessThanRoot = leftInfo == null ? true : leftInfo.max < root.val;
        boolean isMinValOfRightLargeThanRoot = rightInfo == null ? true : rightInfo.min > root.val;
        if (isLeftBST && isRightBST && isMaxValOfLeftLessThanRoot && isMinValOfRightLargeThanRoot) {
            info.isBST = true;
        }

        int leftMaxSize = leftInfo == null ? 0 : leftInfo.maxSize;
        int rightMaxSize = rightInfo == null ? 0 : rightInfo.maxSize;
        //5.更新maxSize
        if (info.isBST) {
            info.head = root;
            info.maxSize = leftMaxSize + rightMaxSize + 1;
        } else {
            info.maxSize = Math.max(leftMaxSize, rightMaxSize);
            //3三种情况
            if (leftInfo == null) {
                info.head = rightInfo.head;
            }

            if (rightInfo == null) {
                info.head = leftInfo.head;
            }

            if (rightInfo != null && leftInfo != null) {
                if (rightInfo.maxSize > leftInfo.maxSize) {
                    info.head = rightInfo.head;
                } else {
                    info.head = leftInfo.head;
                }
            }

        }

        return info;
    }

    public static void main(String[] args) {
        MaxSubBSTHead maxSubBSTHead = new MaxSubBSTHead();
        SerializeAndReconstructTreeLevel level = new SerializeAndReconstructTreeLevel();

        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = MaxSubBSTHeadTest.generateRandomBST(maxLevel, maxValue);
            if (MaxSubBSTHeadTest.maxSubBSTHead1(head) != MaxSubBSTHeadTest.maxSubBSTHead2(head)) {
                System.out.println("Oops!");
            }
            TreeNode node = maxSubBSTHead.maxSubBSTHead(head);
            if (MaxSubBSTHeadTest.maxSubBSTHead1(head) != node) {
                System.out.println(level.masherTreeLevel(head));
                throw new RuntimeException("fuck");
            }
        }
        System.out.println("finish!");
    }
}
