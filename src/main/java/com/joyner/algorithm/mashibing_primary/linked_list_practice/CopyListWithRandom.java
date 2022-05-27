package com.joyner.algorithm.mashibing_primary.linked_list_practice;

import com.joyner.algorithm.mashibing_primary.vo.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点 head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
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
public class CopyListWithRandom {

    /**
     * 使用hashmap
     * @param head
     * @return
     */
    public Node<Integer> copyListWithRand1(Node<Integer> head) {
        Map<Node<Integer>, Node<Integer>> map = new HashMap<>();

        Node<Integer> tempHead = head;
        while (tempHead != null) {
            // node --> newNode
            map.put(tempHead, new Node<Integer>(tempHead.val));
            tempHead = tempHead.next;
        }

        //begin copy
        tempHead = head;
        Node newHead = map.get(tempHead);
        while (tempHead != null) {
            //获取新节点
            Node<Integer> newNode = map.get(tempHead);
            newNode.next = map.get(tempHead.next);

            //处理random节点
            Node<Integer> randomNode = tempHead.random;
            Node<Integer> newRandomNode = map.get(randomNode);
            newNode.random = newRandomNode;

            tempHead = tempHead.next;
        }

        return newHead;


    }

    /**
     *
     *
     * @param head
     * @return
     */
    public Node<Integer> copyListWithRand2(Node<Integer> head) {
        if (head == null) {
            return head;
        }

        Node tempHead = head;
        while (tempHead != null) {
            Node tempNext = tempHead.next;

            Node newNext = new Node(tempHead.val);
            tempHead.next = newNext;
            newNext.next = tempNext;


            tempHead = tempNext;
        }

        //拆分链表
        tempHead = head;
        Node newHead = head.next;
        while (tempHead != null) {
            Node next = tempHead.next.next;

            Node newNode = tempHead.next;
            newNode.next = next == null ? null : next.next;
            newNode.random = tempHead.random == null ? null : tempHead.random.next;

            tempHead.next = next;

            tempHead = next;
        }

        return newHead;



    }

    public static void main(String[] args) {
        Node _1head = new Node(1);
        Node _2node = new Node(2);
        Node _8node = new Node(8);
        Node _9node = new Node(9);

        _1head.next = _2node;
        _2node.next = _8node;
        _8node.next = _9node;

        _2node.random = _9node;


        CopyListWithRandom copyListWithRandom = new CopyListWithRandom();
        Node node = copyListWithRandom.copyListWithRand2(_1head);
        System.out.println();
    }
}
