package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

/**
 * <pre>
 * 给定一棵二叉树的头节点head，
 * 如果这个课是二叉搜素树，则返回1，如果不是，则返回所有二叉搜索树的个数。
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class CountBSTTreeSize {

    class Info {
        boolean isBST;
        int maxSubBST;
        Integer max;
        Integer min;
    }

    /**
     * 以X为头的树，最大的二叉搜索子树的大小
     * 1.以X为头的树就是二叉搜索树，则此时最大的二叉搜索树的大小为1
     * 2.以X为头的树不是二叉搜索树
     *    2.1左子树不为空，累加左子树的最大二叉树
     *    2.2右子树不为空，累加右子树的最大二叉树
     *
     * @param head
     * @return
     */
    public int maxSubBSTSize(TreeNode head) {
        Info info = maxSubBSTSizeHelp(head);
        if (info == null) {
            return 0;
        }
        return info.maxSubBST;
    }

    private Info maxSubBSTSizeHelp(TreeNode head) {
        if (head == null) {
            return null;
        }

        Info leftInfo = maxSubBSTSizeHelp(head.left);
        Info rightInfo = maxSubBSTSizeHelp(head.right);

        Info result = new Info();
        result.maxSubBST = 0;
        //假设为true
        result.isBST = true;
        result.max = head.val;
        result.min = head.val;
        //更新最大值和最小值
        if (leftInfo != null) {
            result.max = Math.max(leftInfo.max, result.max);
            result.min = Math.min(leftInfo.min, result.min);
        }
        if (rightInfo != null) {
            result.max = Math.max(rightInfo.max, result.max);
            result.min = Math.min(rightInfo.min, result.min);
        }

        //更新isBST
        if (leftInfo != null) {
            result.isBST = leftInfo.isBST;
            if (leftInfo.max >= head.val) {
                result.isBST = false;
            }
        }
        if (rightInfo != null) {
            result.isBST = rightInfo.isBST;
            if (rightInfo.min <= head.val) {
                result.isBST = false;
            }
        }


        //更新maxSubBST
        if (result.isBST) {
            result.maxSubBST = 1;
        } else {
            if (leftInfo != null) {
                result.maxSubBST += leftInfo.maxSubBST;
            }

            if (rightInfo != null) {
                result.maxSubBST += rightInfo.maxSubBST;
            }
            //加上自身,先加后减
            result.maxSubBST += 1;
            boolean isLeftVSatisfy = head.left == null ? true : head.left.val < head.val;
            boolean isRightVSatisfy =  head.right == null ? true : head.right.val > head.val;
            if (!isLeftVSatisfy || !isRightVSatisfy) {
                result.maxSubBST -= 1;
            }
        }






        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);

        root.left.left  = new TreeNode(6);

        root.left.left.left  = new TreeNode(1);
        root.left.left.right  = new TreeNode(7);

        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(5);


        SerializeAndReconstructTreeLevel level = new SerializeAndReconstructTreeLevel();
        TreeNode node = level.unMasherTreeLevel("[28,88,null,null,92]");

        CountBSTTreeSize maxSubBSTSize = new CountBSTTreeSize();
        int i = maxSubBSTSize.maxSubBSTSize(node);
        System.out.println(i);



    }
}
