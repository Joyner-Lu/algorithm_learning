package com.joyner.algorithm.mashibing_primary.linked_list_practice;

import com.joyner.algorithm.mashibing_primary.vo.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
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
public class SmallerEqualBigger {

    /**
     * 使用数组来玩partition
     *
     * @param head
     * @return
     */
    public Node smallerEqualBiggerV1(Node head, int pivot) {
        List<Node<Integer>> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        //对数组玩partition
        netherlandsFlag(nodeList, pivot);
        head = nodeList.get(0);
        Node tempNode = head;
        //构建链表
        for (int i = 1; i < nodeList.size(); i++) {
            tempNode.next = nodeList.get(i);
            tempNode = tempNode.next;
        }
        //最后的节点指向null
        nodeList.get(nodeList.size() -1).next = null;

        return head;
    }




    private void netherlandsFlag(List<Node<Integer>> nodeList, int pivot) {
        //分小于区(初始位置-1)，等于区和大于区（初始位置len）
        //如果当前位置小于 pivot. 当前位置和小于区的下一个位置交换，小于区扩一个位置,i++
        //如果当前位置大于 pivot，当前位置和大于区的前一个位置交换，大于区扩一个位置, i不动
        //如果当前位置等于 pivot，跳到下一个位置
        int less = -1;
        int bigger = nodeList.size();
        for (int i = 0; i < nodeList.size(); i++) {
            Node<Integer> node = nodeList.get(i);
            if (node.val > pivot) {
                Node<Integer> nextNode = nodeList.get(--bigger);
                nodeList.set(bigger, node);
                nodeList.set(i, nextNode);
                if (i >= bigger) {
                    break;
                }
                i--;//保持不动
            } else if (node.val < pivot) {
                Node<Integer> nextNode = nodeList.get(++less);
                nodeList.set(less, node);
                nodeList.set(i, nextNode);
            }


        }


    }

    public Node smallerEqualBiggerV2(Node<Integer> head, int pivot) {

        //小于区
        Node<Integer> smallHead = null;
        Node<Integer> smallEnd = null;
        //等于区
        Node<Integer> equalHead = null;
        Node<Integer> equalEnd = null;
        //大于区
        Node<Integer> biggerHead = null;
        Node<Integer> biggerEnd = null;
        Node newHead = null;
        Node<Integer> tempHead = head;
        while (tempHead != null) {
            if (tempHead.val < pivot) {
                if (smallHead == null) {
                    smallHead = tempHead;
                    smallEnd = tempHead;
                } else {
                    //给next
                    smallEnd.next = tempHead;
                    //移到下一个
                    smallEnd = tempHead;
                }
            } else if (tempHead.val > pivot) {
                if (biggerHead == null) {
                    biggerHead = tempHead;
                    biggerEnd = tempHead;
                } else {
                    //给next
                    biggerEnd.next = tempHead;
                    //移到下一个
                    biggerEnd = tempHead;
                }
            } else {
                if (biggerHead == null) {
                    equalHead = tempHead;
                    equalEnd = tempHead;
                } else {
                    //给next
                    equalEnd.next = tempHead;
                    //移到下一个
                    equalEnd = tempHead;
                }
            }

            tempHead = tempHead.next;
        }


        //把小于区的尾部，连上，等于区的头部，等于区的尾部连上大于区的头部
        if (smallHead != null) {
            smallEnd.next = (equalHead == null ? biggerHead : equalHead);
        }

        if (equalHead != null) {
            equalHead.next = biggerHead;
        }

        newHead = (smallHead != null ? smallHead : (equalHead != null ? equalHead : biggerHead));

        return newHead;
    }

    public static void main(String[] args) {
        Node test = null;
        test = new Node(3);
        test.next = new Node(3);
        test.next.next = new Node(5);
        test.next.next.next = new Node(1);
        test.next.next.next.next = new Node(7);
        test.next.next.next.next.next = new Node(3);
        test.next.next.next.next.next.next = new Node(9);


        SmallerEqualBigger smallerEqualBigger = new SmallerEqualBigger();
        Node node = smallerEqualBigger.smallerEqualBiggerV2(test, -1);
        System.out.println();
    }
}
