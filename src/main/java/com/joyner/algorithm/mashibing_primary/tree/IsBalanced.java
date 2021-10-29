package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

/**
 * <pre>
 * 给定一棵二叉树的头节点head，返回这颗二叉树是不是平衡二叉树
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
public class IsBalanced {


    class Info {
        boolean isBalanced;
        int height;
    }

    /**
     * 以X为头的节点，如果想要平衡的条件是
     * 1.左树是平衡的。
     * 2.右树是平衡的
     * 3.左树和右树的高度差不超过1.
     *
     * @param head
     * @return
     */
    public boolean isBalanced(TreeNode head) {
        Info info = isBalancedHelp(head);
        return info.isBalanced;
    }

    private Info isBalancedHelp(TreeNode head) {
        if (head == null) {
            Info info = new Info();
            info.isBalanced = true;
            info.height = 0;
            return info;
        }

        //去弄我的左树
        Info leftInfo = isBalancedHelp(head.left);
        //去弄我的右树
        Info rightInfo = isBalancedHelp(head.right);

        Info result = new Info();
        result.height = Math.max(leftInfo.height, rightInfo.height) + 1;
        result.isBalanced = false;
        if (leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) < 2) {
            result.isBalanced =  true;
        }
        return result;
    }

}
