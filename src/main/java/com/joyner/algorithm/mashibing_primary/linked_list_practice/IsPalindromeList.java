package com.joyner.algorithm.mashibing_primary.linked_list_practice;

import com.joyner.algorithm.mashibing_primary.vo.Node;

import java.util.Stack;

/**
 * <pre>
 * 是否回文链表
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
public class IsPalindromeList {

    public boolean isPalindromeListV1(Node head) {
        if (head == null) {
            return true;
        }
        //先加入栈，顺序是逆序的，如果弹出来的值刚好和原来一样，那么一定是回文的
        Node tempHead = head;
        Stack<Node> stack = new Stack();
        while (tempHead != null) {
            stack.push(tempHead);
            tempHead = tempHead.next;
        }

        //
        tempHead = head;
        while (tempHead != null) {
            Node pop = stack.pop();
            if (!pop.val.equals(tempHead.val)) {
                return false;
            }
            tempHead = tempHead.next;

        }

        return true;
    }

    /**
     *
     *
     * @return
     */
    public boolean isPalindromeListV2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        boolean result = true;
        //1.奇数长度返回中点，偶数长度返回上中点
        Node slowP = head;
        Node fastP = head;

        while (slowP.next != null && fastP.next != null && fastP.next.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        //中点
        Node midNode = slowP;
        Node endNode = fastP.next != null ? fastP.next : fastP;

        //2.从midNode的下一个节点开始，对链表进行reverse。  midNode指向空
        Node preNode = midNode;
        Node curNode = midNode.next;

        //把midNode的next指向null
        midNode.next = null;

        reverse(curNode, preNode);

        //3.比较
        Node tempHead = head;
        Node tempEnd = endNode;

        while (tempHead != null) {
            if (!tempHead.val.equals(tempEnd.val)) {
                result = false;
                break;
            }
            tempHead = tempHead.next;
            tempEnd = tempEnd.next;
        }
        //4.还原原来的链表
        reverse(endNode, null);

        return result;

    }

    private void reverse(Node curNode, Node preNode) {
        while (curNode != null) {
            //先抓住next
            Node next = curNode.next;

            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }


    }


    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(1);
        test.next.next.next = new Node(0);/*
        test.next.next.next.next = new Node(2);
        test.next.next.next.next.next = new Node(1);
        test.next.next.next.next.next.next = new Node(0);*/

        IsPalindromeList isPalindromeList = new IsPalindromeList();
        boolean palindromeListV1 = isPalindromeList.isPalindromeListV2(test);
        System.out.println(palindromeListV1);

    }
}
