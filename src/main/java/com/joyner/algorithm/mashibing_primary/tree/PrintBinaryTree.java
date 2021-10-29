package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

/**
 * <pre>
 *
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
public class PrintBinaryTree {

    private SerializeAndReconstructTreeLevel level = new SerializeAndReconstructTreeLevel();

    /**
     * 横向打印，使用右头左的顺序
     *
     * @param root
     */
    public void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root, 1, "h-");
    }

    /**
     *
     * @param levelTraverseStr 中序序列号的str
     */
    public void print(String levelTraverseStr) {
        TreeNode node = level.unMasherTreeLevel(levelTraverseStr);
        print(node);
    }

    private void print(TreeNode root, int level, String flag) {
        if (root.right != null) {
            print(root.right, level + 1, "v-");
        }
        String space = getSpace(level);
        System.out.println(space + flag + root.val);
        if (root.left != null) {
            print(root.left, level + 1, "^-");
        }
    }

    public String getSpace(int level) {
        String fix = "";
        level = level * 4;
        while (level > 0) {
            fix += " ";
            level--;
        }
        return fix;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        printBinaryTree.print(root);
    }

}
