package com.joyner.algorithm.mashibing_primary;

import com.joyner.algorithm.leetcode_practice.vo.ListNode;
import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
public class RandomGenerator {


    /**
     * 生成长度随机且数据随机的数组。数组范围[0, maxVal - 1]
     * @param maxLen
     * @param maxVal
     * @return
     */
    public static int[] generateRandomArr(int maxLen, int maxVal) {
        int len = (int) (Math.random() * maxLen);
        int[] randomArr = new int[len];
        for (int i = 0; i < len; i++) {
            //相减，这样会产生负数
            randomArr[i] = (int)(Math.random() * maxVal) - (int)(Math.random() * maxVal);
        }
        return randomArr;

    }

    /**
     * 生成随机整数
     *
     * @param maxVal
     * @return
     */
    public static int generateRandomInt(int maxVal) {
        int a = (int) (Math.random() * maxVal);
        int b = (int) (Math.random() * maxVal);
        int ans = a - b;
        return ans;
    }

    /**
     * 生成小写字母随机字符串
     *
     * @param strLen
     * @return
     */
    public static String generateRandomStr(int strLen) {
        if (strLen <= 0) {
            return null;
        }

        char[] chars = new char[strLen];
        for (int j = 0; j < strLen; j++) {
            //[0,25)
            int i = (int) (Math.random() * 26);
            //'a'的ASCII 是97
            char c = (char) (97 + i);
            chars[j] = c;
        }
        return String.valueOf(chars);
    }

    public static String[] generateRandomStrArr(int maxArrLen, int maxStrLen) {
        if (maxStrLen < 1) {
            throw new RuntimeException("最大长度不能小于1");
        }
        if (maxArrLen < 1) {
            throw new RuntimeException("数组长度不能小于1");
        }
        RandomBox randomBox = new RandomBox(1, maxStrLen);
        String[] result = new String[(int)(Math.random()*maxArrLen) + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = generateRandomStr(randomBox.random());
        }
        return result;

    }

    /**
     * 生成随机整数
     *
     * @param maxVal
     * @return
     */
    public static int generateRandomIntWithoutNegative(int maxVal) {
        int ans = (int) (Math.random() * maxVal);
        return ans;
    }


    /**
     * 生成最大节点上为：maxNodeCount - 1 的二叉树。
     * 节点的值范围是：[0, maxVal-1]
     * @param maxNodeCount
     * @param maxVal
     * @return
     */
    public static TreeNode generateRandomTree(int maxNodeCount, int maxVal) {
        int nodeCount = (int)(Math.random() * maxNodeCount);
        System.out.println("tree node counts :" + nodeCount);
        if (nodeCount == 0) {
            return null;
        }
        int nodeVal = (int)(Math.random() * maxVal);
        TreeNode head = new TreeNode(nodeVal);

        //

        //1.根入队。
        //2.取出根，给根赋值左孩子和右孩子，每赋值一个节点，nodeCount--，到0为止。
        //3.将左右孩子入队，左和根同样的操作，直到nodeCount为0为止。
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(head);
        nodeCount--;

        while (nodeCount > 0) {
            TreeNode node = queue.poll();
            //生成左孩子
            nodeVal = (int)(Math.random() * maxVal);
            TreeNode leftNode = new TreeNode(nodeVal);
            nodeCount--;
            node.left = leftNode;
            if (nodeCount <= 0) {
                break;
            }

            //生成右孩子
            nodeVal = (int)(Math.random() * maxVal);
            TreeNode rightNode = new TreeNode(nodeVal);
            nodeCount--;
            node.right = rightNode;
            if (nodeCount <= 0) {
                break;
            }

            queue.offer(leftNode);
            queue.offer(rightNode);
        }
        return head;



    }


    /**
     * 生成最大节点上为：maxNodeCount - 1 的二叉搜索树。
     * 节点的值范围是：[-(maxVal - 1), maxVal-1]
     * @param maxNodeCount
     * @param maxVal
     * @return
     */
    public static TreeNode generateRandomBST(int maxNodeCount, int maxVal) {
        //构建RandomBox
        RandomBox randomBox = new RandomBox(-(maxVal - 1), maxVal - 1);

        int nodeCount = (int)(Math.random() * maxNodeCount);
        System.out.println("bst node counts :" + nodeCount);
        if (nodeCount == 0) {
            return null;
        }
        int nodeVal = randomBox.random();
        TreeNode head = new TreeNode(nodeVal);

        //

        //1.根入队。
        //2.取出根，给根赋值左孩子和右孩子，每赋值一个节点，nodeCount--，到0为止。
        //3.将左右孩子入队，左和根同样的操作，直到nodeCount为0为止。
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(head);
        nodeCount--;

        while (nodeCount > 0) {
            TreeNode node = queue.poll();
            //生成左孩子
            nodeVal = (int)(Math.random() * maxVal);
            TreeNode leftNode = new TreeNode(nodeVal);
            nodeCount--;
            node.left = leftNode;
            if (nodeCount <= 0) {
                break;
            }

            //生成右孩子
            nodeVal = (int)(Math.random() * maxVal);
            TreeNode rightNode = new TreeNode(nodeVal);
            nodeCount--;
            node.right = rightNode;
            if (nodeCount <= 0) {
                break;
            }

            queue.offer(leftNode);
            queue.offer(rightNode);
        }
        return head;



    }



    /**
     * 生成长度随机，值随机的双向链表
     * @param maxLen
     * @param maxVal
     * @return
     */
    public static ListNode generateRandomDoubleLinkedList(int maxLen, int maxVal) {
        int len = (int)(Math.random() * maxLen);
        if (len == 0) {
            System.out.println(" _0_len..................");
        }
        ListNode head = null;
        ListNode curr = null;
        while (len > 0) {
            int val = (int)(Math.random() * maxVal);
            ListNode listNode = new ListNode(val);
            if (head == null) {
                head = listNode;
                curr = head;
            } else {
                curr.next = listNode;
                listNode.pre = curr;
                curr = listNode;
            }
            len--;
        }
        return head;

    }

    public static void main(String[] args) {


        String[] strings = generateRandomStrArr(5, 20);
        for (int i = 0; i < strings.length; i++) {
            String st = strings[i];
            System.out.println(st);
        }

    }
}
