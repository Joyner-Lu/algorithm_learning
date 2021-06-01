package com.joyner.algorithm.mashibing_primary.linked_list_practice;

import com.joyner.algorithm.mashibing_primary.vo.Node;

/**
 * <pre>
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class TwoLinkedIntersectList {


    class CycleInfo {
        //第一个入环点
        public Node firstCycleNode = null;
        //走到入环点的距离
        public Integer length = null;
        public boolean isHasCycle = false;
        public Node endNode = null;

        @Override
        public String toString() {
            return "CycleInfo{" +
                    "firstCycleNode=" + firstCycleNode +
                    ", isHasCycle=" + isHasCycle +
                    ", endNode=" + endNode +
                    '}';
        }
    }


    public Node intersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node result = null;

        CycleInfo loop1 = isCycleLinkedList(head1);
        CycleInfo loop2 = isCycleLinkedList(head2);

        //1.如果head1无环，head2无环,可能相交
        //2.如果head1有环，head2也有环，也有可能相交
        //3.如果一个有环一个无环，则不可能相交
        if (!loop1.isHasCycle && !loop2.isHasCycle) {
            if (loop1.endNode.equals(loop2.endNode)) {
                //开始找相交点，head1和head2同时走。例如head1走到null,里面切到head2，继续走，head2走到null,立马切到head1继续
                //走，直到相遇一定就是相交点
                Node tempHead1 = head1;
                Node tempHead2 = head2;
                while (tempHead1 != null || tempHead2 != null) {
                    if (tempHead1.equals(tempHead2)) {
                        result = tempHead1;
                        break;
                    }

                    tempHead1 = tempHead1.next;
                    tempHead2 = tempHead2.next;

                    if (tempHead1 == null) {
                        tempHead1 = head2;
                    } else if (tempHead2 == null) {
                        tempHead2 = head1;
                    }

                }



            }
        } else if (loop1.isHasCycle && loop2.isHasCycle) {


            if (loop1.firstCycleNode.equals(loop2.firstCycleNode)) {
                //1.入环点一样，找出相交的点
                Node tempHead1 = head1;
                Node tempHead2 = head2;
                
                //长的先要走的步数
                Integer length1 = loop1.length;
                Integer length2 = loop2.length;
                int step = Math.abs(length1 - length2);

                if (loop1.length > loop2.length) {
                    //1先走
                    while (step > 0) {
                        tempHead1 = tempHead1.next;
                        step--;
                    }
                } else {
                    //2先走
                    while (step > 0) {
                        tempHead2 = tempHead2.next;
                        step--;
                    }
                }

                //同时走
                while (!tempHead1.equals(tempHead2)) {
                    tempHead1 = tempHead1.next;
                    tempHead2 = tempHead2.next;
                }

                result = tempHead2;
            } else {
                //2.入环点不一样，则随便返回其中一个
                result = loop1.firstCycleNode;
            }

        }

        return result;

    }



    /**
     * 如果无环，返回null,如果有环，返回入环的第一个节点
     *
     * @param head
     * @return
     */
    public CycleInfo isCycleLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        CycleInfo cycleInfo = new CycleInfo();

        Node fastNode = head;
        Node slowNode = head;
        while (fastNode != null) {
            if (fastNode.next == null) {
                cycleInfo.endNode = fastNode;
                break;
            }
            Node tempNode = fastNode.next.next;
            if (tempNode == null) {
                cycleInfo.endNode = fastNode.next;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (slowNode.equals(fastNode)) {
                //证明有环，下面开始找入环点
                cycleInfo.isHasCycle = true;

                //遇到之后跳出来。然后fastNode指向head.每次走一步，遇到slowNode的时候也就是相交点
                //证明参考：https://blog.csdn.net/weixin_45481403/article/details/102871456
                fastNode = head;
                int idx = 0;
                while (!fastNode.equals(slowNode)) {
                    idx++;
                    fastNode = fastNode.next;
                    slowNode = slowNode.next;
                }
                cycleInfo.length = idx;
                cycleInfo.firstCycleNode = fastNode;

                return cycleInfo;
            }
        }

        return cycleInfo;
    }

    public static void main(String[] args) {

        TwoLinkedIntersectList twoLinkedIntersectList = new TwoLinkedIntersectList();
        Node _3 = new Node(3);
        Node _4 = new Node(4);
        Node _5 = new Node(5);
        Node _6 = new Node(6);
        Node _7 = new Node(7);


        Node head1 = null;
        head1 = new Node(1);
        head1.next = new Node(8);
        head1.next.next = _3;
        head1.next.next.next = _4;
        head1.next.next.next.next =_5;
        head1.next.next.next.next.next = _6;
        head1.next.next.next.next.next.next = _7;
        head1.next.next.next.next.next.next.next = _4;

        Node head2 = null;
        head2 = new Node(11);
        head2.next = new Node(18);
        head2.next.next = _5;


        System.out.println(twoLinkedIntersectList.intersectNode(head1, head2));

    }

    private void demo1() {
        Node _3 = new Node(3);
        Node _4 = new Node(3);
        Node _5 = new Node(3);


        Node head1 = null;
        head1 = new Node(1);
        head1.next = new Node(8);;
        head1.next.next = _3;
        head1.next.next.next = _4;
        head1.next.next.next.next =_5;
        //test.next.next.next.next.next = new Node(31);
        //test.next.next.next.next.next.next = _3;

        Node head2 = null;
        head2 = new Node(11);
        head2.next = new Node(18);
        head2.next.next = new Node(2);;
        head2.next.next.next = _3;
        head2.next.next.next.next = _4;
        head2.next.next.next.next.next =_5;
    }


    private void demo2() {
        Node _3 = new Node(3);
        Node _4 = new Node(4);
        Node _5 = new Node(5);
        Node _6 = new Node(6);
        Node _7 = new Node(7);


        Node head1 = null;
        head1 = new Node(1);
        head1.next = new Node(8);
        head1.next.next = _3;
        head1.next.next.next = _4;
        head1.next.next.next.next =_5;
        head1.next.next.next.next.next = _6;
        head1.next.next.next.next.next.next = _7;
        head1.next.next.next.next.next.next.next = _4;

        Node head2 = null;
        head2 = new Node(11);
        head2.next = new Node(18);
        head2.next.next = _3;
    }

    private void demo3() {
        Node _3 = new Node(3);
        Node _4 = new Node(4);
        Node _5 = new Node(5);
        Node _6 = new Node(6);
        Node _7 = new Node(7);


        Node head1 = null;
        head1 = new Node(1);
        head1.next = new Node(8);
        head1.next.next = _3;
        head1.next.next.next = _4;
        head1.next.next.next.next =_5;
        head1.next.next.next.next.next = _6;
        head1.next.next.next.next.next.next = _7;
        head1.next.next.next.next.next.next.next = _4;

        Node head2 = null;
        head2 = new Node(11);
        head2.next = new Node(18);
        head2.next.next = _5;
    }
}
