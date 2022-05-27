package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

import java.util.*;

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
public class SerializeAndReconstructTreeLevel {

    private final static String EMPTY_TREE = "[]";

    MaxSubBSTHead maxSubBSTHead = new MaxSubBSTHead();
    private int idx = 0;

    public String masherTreeLevel(TreeNode root) {
        if (root == null) {
            return EMPTY_TREE;
        }
        List<String> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                arr.add("null");
            } else {
                arr.add(poll.val + "");
            }
            if (poll != null) {
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        //去掉尾部的空null
        for (int i = arr.size() - 1; i >= 0; i--) {
            String val = arr.get(i);
            if ("null".equals(val)) {
                arr.remove(i);
            } else {
                break;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i) + ",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }

    /**
     * 反序列号
     *
     * @return
     */
    public TreeNode unMasherTreeLevel(String treeStr) {
        if (EMPTY_TREE.equals(treeStr)) {
            return null;
        }

        String[] treeStrArr = treeStr.substring(1, treeStr.length() - 1).split(",");
        TreeNode head = buildTree(treeStrArr);
        return head;
    }

    private TreeNode buildTree(String[] treeStrArr) {

        Queue<TreeNode> queue = new LinkedList();

        if ("null".equals(treeStrArr[idx].trim())) {
            return null;
        }

        int idx = 0;
        TreeNode root = new TreeNode(treeStrArr[idx]);
        queue.offer(root);
        while (!queue.isEmpty() && idx < treeStrArr.length -1) {
            TreeNode poll = queue.poll();
            poll.left = TreeNode.build(treeStrArr[++idx]);
            if (idx >= treeStrArr.length - 1) {
                break;
            }
            poll.right = TreeNode.build(treeStrArr[++idx]);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }

        }
        return root;

    }


    public static void main(String[] args) {
        MaxSubBSTHead maxSubBSTHead = new MaxSubBSTHead();
        SerializeAndReconstructTreeLevel serializeAndReconstructTree = new SerializeAndReconstructTreeLevel();

        TreeNode node = serializeAndReconstructTree.unMasherTreeLevel("[27,18,21,26,81,21,24,74,43,null,69,null,46,null,11]");
        //System.out.println(node);

        PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        printBinaryTree.print(node);
        TreeNode node1 = MaxSubBSTHeadTest.maxSubBSTHead1(node);
        System.out.println(node1);
        TreeNode node2 = maxSubBSTHead.maxSubBSTHead(node);
        System.out.println(node2);
    }

}
