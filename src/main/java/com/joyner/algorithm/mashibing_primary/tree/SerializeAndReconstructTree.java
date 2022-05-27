package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

import java.util.Stack;

/**
 * <pre>
 * 二叉树的序列化和反序列化
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
public class SerializeAndReconstructTree {


    /**
     * 序列化树（使用前序）
     * 方法：使用前序遍历，放入到数组里面。记住，空节点也要放
     *
     * @param treeNode
     */
    public String masherTreePreOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        String treeStr = "[";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            treeStr += (pop == null ? "null" : pop.val) + ",";
            if (pop == null) {
                continue;
            }

            if (pop.right != null) {
                stack.push(pop.right);
            } else {
                stack.push(null);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            } else {
                stack.push(null);
            }
        }
        if (treeStr.length() > 1) {
            treeStr = treeStr.substring(0, treeStr.length() -1);
        }
        System.out.println();
        treeStr += "]";
        System.out.println(treeStr);

        return treeStr;
    }

    private int idx = 0;

    /**
     * 反序列号
     *
     * @return
     */
    public TreeNode unMasherTreePreOrder(String treeStr) {
        if (treeStr == null) {
            return null;
        }

        String[] treeStrArr = treeStr.substring(1, treeStr.length() - 1).split(",");
        TreeNode head = buildTree(treeStrArr);
        return head;
    }

    private TreeNode buildTree(String[] treeStrArr) {
        if (idx >= treeStrArr.length || "null".equals(treeStrArr[idx].trim())) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(treeStrArr[idx].trim()));
        idx++;//建左树用掉一个
        node.left = buildTree(treeStrArr);
        idx++;//建右树用掉一个
        node.right = buildTree(treeStrArr);
        return node;
    }


    public static void main(String[] args) {
        SerializeAndReconstructTree serializeAndReconstructTree = new SerializeAndReconstructTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);

        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(9);

        String treeStr = serializeAndReconstructTree.masherTreePreOrder(root);

        TreeNode node = serializeAndReconstructTree.unMasherTreePreOrder(treeStr);
        System.out.println();

        /*PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        printBinaryTree.print(node);*/
    }

}
