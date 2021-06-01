package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

import java.util.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class SerializeAndDeserializeBinaryTree_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        //[1, 2, 3]
        //刚开始index = 0 第一轮加完1， 2，3 ，然后index 1,
        //不断往后加，也就是bfs
        for (int i = 0; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            if (treeNode == null) {
                continue;
            }
            list.add(treeNode.left);
            list.add(treeNode.right);
        }

        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            if (treeNode == null) {
                sb.append("#,");
            } else {
                sb.append(treeNode.val + ",");
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] dataArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        List<TreeNode> list = new ArrayList<>();
        int index = 0;//维持list中的索引
        boolean isLeft = true;
        list.add(root);
        for (int i = 1; i < dataArr.length; i++) {
            if (!dataArr[i].equals("#")) {
                TreeNode treeNode = list.get(index);
                //构建树节点
                TreeNode temp = new TreeNode(Integer.parseInt(dataArr[i]));
                if (isLeft) {
                    treeNode.left = temp;
                } else {
                    treeNode.right = temp;
                }
                list.add(temp);
            }

            if (!isLeft) {
                index++;//右节点需要处理完毕
            }

            //左右切换
            isLeft = !isLeft;
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode temp = root;
        temp.left = new TreeNode(2);
        temp = temp.right = new TreeNode(3);
        temp.left = new TreeNode(4);
        temp.right = new TreeNode(5);


        SerializeAndDeserializeBinaryTree_297 serializeAndDeserializeBinaryTree_297 = new SerializeAndDeserializeBinaryTree_297();
        String result = serializeAndDeserializeBinaryTree_297.serialize(root);
        System.out.println(result);

        TreeNode resultNode = serializeAndDeserializeBinaryTree_297.deserialize(result);
        System.out.println(resultNode);
    }
}
