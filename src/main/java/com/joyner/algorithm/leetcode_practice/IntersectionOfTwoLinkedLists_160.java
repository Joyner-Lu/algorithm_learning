package com.joyner.algorithm.leetcode_practice;

import com.joyner.algorithm.leetcode_practice.vo.ListNode;

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
public class IntersectionOfTwoLinkedLists_160 {

    public ListNode getIntersectionNodev1(ListNode headA, ListNode headB) {


        while (headB != null) {
            ListNode tempNode = headB;
            ListNode intersectionNode = find(tempNode, headA);
            if (intersectionNode != null) {
                return intersectionNode;
            }
            headB = headB.next;
        }
        return null;
    }


    /**
     * 创建两个指针 pApA 和 pBpB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     * 当 pApA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     * 若在某一时刻 pApA 和 pBpB 相遇，则 pApA/pBpB 为相交结点。
     * 想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length (=6)，pBpB 比 pApA 少经过 22 个结点，会先到达尾部。将 pBpB 重定向到 A 的头结点，pApA 重定向到 B 的头结点后，pBpB 要比 pApA 多走 2 个结点。因此，它们会同时到达交点。
     * 如果两个链表存在相交，它们末尾的结点必然相同。因此当 pApA/pBpB 到达链表结尾时，记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode originalHeadA = headA;
        ListNode originalHeadB = headB;
        boolean flagA = true;
        boolean flagB = true;

        while (headA != null || headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;

            if (headA == null && flagA) {
                headA = originalHeadB;
                flagA = false;
            }
            if (headB == null  && flagB) {
                headB = originalHeadA;
                flagB = false;
            }
        }

        return null;


    }


    private ListNode find(ListNode tempNode, ListNode headA) {
        while (headA.hashCode() != tempNode.hashCode()) {
            headA = headA.next;
            if (headA == null) {
                break;
            }
        }
        return headA;
    }

    private ListNode reverse(ListNode headNode) {
        ListNode preNode = null;
        ListNode prePreNode = null;
        while (headNode != null) {
            preNode = headNode;
            headNode = headNode.next;
            preNode.next = prePreNode;
            prePreNode = preNode;
        }

        return preNode;
    }


    public static void main(String[] args) {
        ListNode common1 = new ListNode(1);
        ListNode common8 = new ListNode(8);
        ListNode common4 = new ListNode(4);
        ListNode headA = new ListNode(4);
        ListNode preHeadA = headA;
        headA = headA.next = new ListNode(1);
        headA = headA.next = common8;
        headA = headA.next = new ListNode(4);
        headA = headA.next = new ListNode(5);


        ListNode headB = new ListNode(5);
        ListNode preHeadB = headB;
        headB = headB.next = new ListNode(6);
        headB = headB.next = new ListNode(1);
        headB = headB.next = common8;
        headB = headB.next = new ListNode(4);
        headB = headB.next = new ListNode(5);


        IntersectionOfTwoLinkedLists_160 intersectionOfTwoLinkedLists_160 = new IntersectionOfTwoLinkedLists_160();
        ListNode result = intersectionOfTwoLinkedLists_160.getIntersectionNode(preHeadA, preHeadB);
        System.out.println(result.val);
    }

}
