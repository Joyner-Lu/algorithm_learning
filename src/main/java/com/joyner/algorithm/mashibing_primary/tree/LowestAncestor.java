package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * <pre>
 * 给定一棵二叉树的头节点head，和另外两个节点a和b。
 * 返回a和b的最低公共祖先
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
public class LowestAncestor {

    class Info {
        boolean hasAncestor = false;
        TreeNode ancestor;
    }

    /**
     * 以X为头的节点,以及任意的两个节点p和q.
     * 1.p在左子树， q在右子树，也就是左右都是右祖先的（自己可以时自己的祖先），那么必然x就是最低的祖先
     * 2.p在左子树，q也在左子树，或者p在右子树，q也在右子树，那么必然公共祖先就是p或者q
     * 3.如果p或者q其中有一个是x，那么祖先必然就是x
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root,  TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Info info = lowestAncestorHelp(root, p, q);
        return info.ancestor;
    }

    private Info lowestAncestorHelp(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            Info info = new Info();
            return info;
        }

        Info leftInfo = lowestAncestorHelp(root.left, p, q);
        Info rightInfo = lowestAncestorHelp(root.right, p, q);

        Info result = new Info();
        if(root.equals(p) || root.equals(q)) {
            //x节点就是，则直接返回
            result.hasAncestor = true;
            result.ancestor = root;
            return result;
        }

        if ((leftInfo.hasAncestor && rightInfo.hasAncestor)) {
            result.hasAncestor = true;
            result.ancestor = root;
        } else if (leftInfo.hasAncestor) {
            //只有左边有，取左
            result.hasAncestor = true;
            result.ancestor = leftInfo.ancestor;
        } else if (rightInfo.hasAncestor) {
            //只有右边有，取右
            result.hasAncestor = true;
            result.ancestor = rightInfo.ancestor;
        }
        return result;
    }

    public static void main(String[] args) {

        PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        printBinaryTree.print("[6,2,8,0,4,7,9,null,null,3,5]");
    }
}
