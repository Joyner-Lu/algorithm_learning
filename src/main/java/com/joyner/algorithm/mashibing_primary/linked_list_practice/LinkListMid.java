package com.joyner.algorithm.mashibing_primary.linked_list_practice;

import com.joyner.algorithm.mashibing_primary.vo.Node;

/**
 * <pre>
 *
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
public class LinkListMid {

    /**
     * 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
     * 例如：1 2 3 4  中点有2和3,上中点就是2，下中点就是3.
     * @return
     */
    public Node midOrUpMidNodeV1(Node head) {
        if (head == null) {
            return null;
        }
        int size = 0;
        Node tempNode = head;
        while (tempNode != null) {
            size++;
            tempNode = tempNode.next;
        }

        int mid = size / 2;
        tempNode = head;
        mid--;
        while (mid > 0) {
            mid--;
            tempNode = tempNode.next;
        }

        return tempNode;

    }

    /**
     * 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
     * 快慢指针法
     * @param head
     * @return
     */
    public Node midOrUpMidNodeV2(Node head) {
        if (head == null) {
            return head;
        }

        Node slowP = head;
        Node fastP = head;
        while (slowP.next != null && fastP.next != null && fastP.next.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }


        return slowP;

    }

    /**
     * 输入链表头节点，奇数长度返回中点，偶数长度返回下中点
     *
     * @param head
     * @return
     */
    public Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slowP = head.next;
        Node fastP = head.next;
        while (slowP.next != null && fastP.next != null && fastP.next.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        return slowP;
    }

    /**
     * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
     *
     * @param head
     * @return
     */
    public Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            //两个节点也返回null
            return null;
        }

        Node slowP = head;
        //先走两步
        Node fastP = head.next.next;
        while (slowP.next != null && fastP.next != null && fastP.next.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        return slowP;
    }

    /**
     * 输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
     *
     * @param head
     * @return
     */
    public Node midOrDownMidPreNode(Node head) {
        if (head ==  null || head.next == null) {
            return null;
        }

        if (head.next.next == null) {
            //两个节点
            return head;
        }

        Node slowP = head;
        Node fastP = head.next;
        while (slowP.next != null && fastP.next != null && fastP.next.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        return slowP;

    }

    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(4);
        test.next.next.next.next.next = new Node(5);


        LinkListMid linkListMid = new LinkListMid();
        Node node = linkListMid.midOrUpMidNodeV2(test);
        System.out.println(node);

    }

}
