package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.ListNode;

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
public class LinkedListCycle_141 {

    /**
     * 使用快慢指针法则
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode rabbitNode = head;//兔子每次走两次
        ListNode tortoiseNode = head;
        while (true) {
            tortoiseNode = tortoiseNode.next;

            if (tortoiseNode == null) {
                return false;
            }
            rabbitNode = rabbitNode.next;
            if (rabbitNode == null || (rabbitNode = rabbitNode.next) == null) {
                return false;
            }
            if (tortoiseNode.equals(rabbitNode)) {
                return true;
            }

        }

    }

    public static void main(String[] args) {
        ListNode common = new ListNode(1);
       /* ListNode common = new ListNode(2);
        ListNode head = new ListNode(3);
        ListNode preHead = head;
        head = head.next = listNode2;
        head = head.next = new ListNode(0);
        head = head.next = new ListNode(-4);*/
        //head = head.next = listNode2;

        ListNode head = common;
        head.next = common;
        ListNode preHead = head;

        LinkedListCycle_141 linkedListCycle_141 = new LinkedListCycle_141();
        boolean tr = linkedListCycle_141.hasCycle(preHead);
        System.out.println(tr);
    }
}
