package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.ListNode;

/**
 * <pre>
 *反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
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
public class ReverseList_v2_206 {


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            //把下一个节点保存起来
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;

        }
        return pre;
    }

    public static void main(String[] args) {
        ReverseList_v2_206 reverseList_206 = new ReverseList_v2_206();
        //1->2->3->4->5->NULL
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        ListNode head = new ListNode(1);
        pre = pre.next = head;

        pre = pre.next = new ListNode(2);
        pre = pre.next = new ListNode(3);
        pre = pre.next = new ListNode(4);
        pre = pre.next = new ListNode(6);
        head.print();
        head = reverseList_206.reverseList(head);
        head.print();
    }
}
