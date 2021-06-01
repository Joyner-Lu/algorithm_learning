package com.joyner.algorithm.mashibing_primary;

import com.joyner.algorithm.mashibing_primary.vo.Node;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * <pre>
 * 栈实现。链表实现，头插入且头取出。
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
public class MyStack<V>  {

    private Node<V> head;
    private Node<V> tail;
    private int size;

    public MyStack() {
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

    public void push(V value) {
        Node<V> cur = new Node<>(value);
        if (head == null && tail == null) {
            head = cur;
        } else {
            cur.next = head;
            head = cur;
        }
        size++;
    }

    public V pop() {
        if (head == null) {
            return null;
        }
        V result = head.val;
        size--;
        head = head.next;
        if (head == null) {
            //保持一致
            tail = null;
        }
        return result;
    }

    public V peek() {
        return head.val;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size);

    }
}
