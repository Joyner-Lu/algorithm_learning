package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.ListNode;
import com.joyner.algorithm.leetcode_practice.vo.TreeNode;

/**
 * <pre>
 *我们可以如下递归地定义两个链表里的 merge 操作（忽略边界情况，比如空链表等）：
 *
 * \left\{ \begin{array}{ll} list1[0] + merge(list1[1:], list2) & list1[0] < list2[0] \\ list2[0] + merge(list1, list2[1:]) & otherwise \end{array} \right.
 * {
 * list1[0]+merge(list1[1:],list2)
 * list2[0]+merge(list1,list2[1:])
 * ​
 *
 * list1[0]<list2[0]
 * otherwise
 * ​
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
public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }


    public ListNode mergeTwoListsv111(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsv111(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsv111(l1, l2.next);
            return l2;
        }

    }

    public ListNode mergeTwoListsv2222(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = (l1 == null ? l2 : l1);
        return preHead.next;

    }




    public ListNode mergeTwoListsv2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists_21 mergeTwoSortedLists_21 = new MergeTwoSortedLists_21();
        ListNode one = new ListNode(1);
        ListNode temp = one.next = new ListNode(2);
        temp.next = new ListNode(4);

        ListNode two = new ListNode(1);
        temp = two.next = new ListNode(3);
        temp.next = new ListNode(4);
        //ListNode result = mergeTwoSortedLists_21.mergeTwoListsv2(one, two);
        ListNode result1 =mergeTwoSortedLists_21.mergeTwoListsv2222(one, two);
        System.out.println();

    }


}
