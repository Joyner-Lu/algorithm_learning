package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.ListNode;

import java.util.Stack;

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
public class ReverseList_206 {


    public ListNode reverseList(ListNode head) {
        /**
         * 假设存在链表 1 \rightarrow 2 \rightarrow 3 \rightarrow \varnothing1→2→3→∅，我们想要把它改成 \varnothing \leftarrow 1 \leftarrow 2 \leftarrow 3∅←1←2←3。
         *
         * 在遍历列表时，将当前节点的 \textit{next}next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
         *
         */
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            //挪到下一个节点
            pre = curr;
            curr = temp;

        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static void main(String[] args) {
        ReverseList_206 reverseList_206 = new ReverseList_206();
        //1->2->3->4->5->NULL
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        ListNode head = new ListNode(1);
        pre = pre.next = head;

        pre = pre.next = new ListNode(2);
        pre = pre.next = new ListNode(3);
        pre = pre.next = new ListNode(4);
        pre = pre.next = new ListNode(6);
        head = reverseList_206.reverseList(head);
    }
}
