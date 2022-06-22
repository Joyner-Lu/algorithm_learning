package com.joyner.algorithm.mashibing_primary;

import com.joyner.algorithm.leetcode_practice.vo.ListNode;
import com.joyner.algorithm.mashibing_primary.vo.Node;
import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * <pre>
 * 自个实现的队列，链表实现
 *
 * 使用尾插法头取值
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
public class MyQueue<V> {

    /**
     * 使用尾插法头取值
     */
    private Node<V> head;
    private Node<V> tail;
    private int size;

    public MyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void offer(V value) {
        //构建节点
        Node<V> curNode = new Node(value);
        if (head == null && tail == null) {
            head = curNode;
            tail = curNode;
        } else {
            tail.next = curNode;
            tail = curNode;
        }
        size++;
    }

    public V poll() {
        if (head == null) {
            return null;
        }
        V result = head.getVal();
        size--;
        //从头部取值
        head = head.next;
        if (head == null) {
            //保持一致
            tail = null;
        }
        return result;

    }

    public V peek() {
        return head.getVal();
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue();
        myQueue.offer(3);
        myQueue.offer(2);
        myQueue.offer(1);

        System.out.println(myQueue.poll());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

        System.out.println(myQueue.size);
        System.out.println(myQueue.isEmpty());

    }

}
