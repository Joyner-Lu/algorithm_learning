package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

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
public class SymmetricTreev2_101 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean v = p.val == q.val;
        boolean l = check(p.left, q.right);
        boolean r = check(p.right, q.left);
        return v & l & r;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTreev2_101 symmetricTree_101 = new SymmetricTreev2_101();
        boolean b = symmetricTree_101.isSymmetric(root);
        System.out.println(b);

    }
}
