package com.joyner.algorithm.mashibing_primary;

import com.joyner.algorithm.leetcode_practice.vo.ListNode;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

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
public class ReverseDoubleLinkedList {

    public ListNode reverses(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            //把next抓住
            next = head.next;
            head.next = pre;
            head.pre = next;

            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 检查反序的结果
     * @param head
     * @param originOrder
     * @return
     */
    public boolean check(ListNode head, List<ListNode> originOrder) {
        //检查反序
        for (int i = originOrder.size() - 1; i >= 0; i--) {
            ListNode node = originOrder.get(i);
            if (!node.equals(head)) {
                return false;
            }
            if (head.next != null) {
                head = head.next;
            }
        }

        //检查正序
        for (int i = 0; i < originOrder.size(); i++) {
            ListNode node = originOrder.get(i);
            if (!node.equals(head)) {
                return false;
            }
            if (head.pre != null) {
                head = head.pre;
            }
        }
        return true;
    }

    public List<ListNode> originOrder(ListNode head) {
        List<ListNode> arr = new ArrayList<>();
        if (head != null) {
            do {
                arr.add(head);
            } while ((head = head.next) != null);
        }
        return arr;

    }


    public static void main(String[] args) {
        ReverseDoubleLinkedList doubleLinkedList = new ReverseDoubleLinkedList();
      /*  ListNode _2= new ListNode(2);
        ListNode _1 = new ListNode(1);

        ListNode head = _1;
        head.next =_2;
        ListNode _3 = head.next.next = new ListNode(3);
        _3.pre = _2;
        _2.pre = _1;
        List<ListNode> listNodes = doubleLinkedList.originOrder(head);
        head = doubleLinkedList.reverses(head);
        boolean check = doubleLinkedList.check(head, listNodes);
        System.out.println(check);*/


        int maxLen = 50;
        int maxVal = 200;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            ListNode head = RandomGenerator.generateRandomDoubleLinkedList(maxLen, maxVal);
            List<ListNode> originOrder = doubleLinkedList.originOrder(head);
            //传递的是引用的副本
            head = doubleLinkedList.reverses(head);
            if (!doubleLinkedList.check(head, originOrder)) {
                throw new RuntimeException("fuck!");
            }

        }

        System.out.println("perfect done.......");







    }

}
