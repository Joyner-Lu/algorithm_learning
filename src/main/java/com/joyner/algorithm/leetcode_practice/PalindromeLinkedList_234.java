package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.ListNode;

import java.util.ArrayDeque;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;

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
public class PalindromeLinkedList_234 {

    private ArrayDeque<Integer> deque = new ArrayDeque<>();

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        while (head != null) {
            deque.addFirst(head.val);
            head = head.next;
        }

        while (!deque.isEmpty() && deque.size() != 1) {
            if (deque.removeFirst().intValue() != deque.removeLast().intValue()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        ListNode preHead = head;
        head = head.next = new ListNode(-129);
       /* head = head.next = new ListNode(2);
        head = head.next = new ListNode(1);*/



        PalindromeLinkedList_234 palindromeLinkedList_234 = new PalindromeLinkedList_234();
        boolean r = palindromeLinkedList_234.isPalindrome(preHead);
        System.out.println(r);
    }

}
