package com.joyner.algorithm.leetcode_practice.vo;

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
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode pre;

    public ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        System.out.print(val + "->");
        ListNode temp = next;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}
