package com.joyner.algorithm.leetcode_practice;


import java.util.List;

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
public class MinStack_155 {

    private ListNode stackTop = null;
    private int minimumVal = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack_155() {

    }
    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void push(int x) {
        //更新最小值
        if (x < minimumVal) {
            //更新最小值
            minimumVal = x;
        }

        if (stackTop == null) {
            stackTop = new ListNode(x);
        } else {
            ListNode newStackTop = new ListNode(x);
            newStackTop.next = stackTop;
            stackTop = newStackTop;
        }
    }

    public void pop() {
        if (minimumVal == stackTop.val) {
            minimumVal = Integer.MAX_VALUE;//初始化
            //最小值弹出去了，需要更新最小值
            ListNode tempNode = stackTop.next;
            while (tempNode != null) {
                if (tempNode.val < minimumVal) {
                    minimumVal = tempNode.val;
                }
                tempNode = tempNode.next;
            }
        }

        if (stackTop != null) {
            stackTop = stackTop.next;
        }
    }

    public int top() {
        return stackTop.val;
    }

    public int getMin() {
        return minimumVal;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        MinStack_155 minStack = new MinStack_155();
        sb.append("null,");
        int val = 0;
        minStack.push(2147483646);
        sb.append("null,");
        minStack.push(2147483646);
        sb.append("null,");
        minStack.push(2147483647);
        sb.append("null,");

        val = minStack.top();
        sb.append(val + ",");
        minStack.pop();
        sb.append("null,");
        val = minStack.getMin();
        sb.append(val + ",");

        minStack.pop();
        sb.append("null,");

        val = minStack.getMin();
        sb.append(val + ",");
        minStack.pop();
        sb.append("null,");

        minStack.push(2147483647);
        sb.append("null,");
        val = minStack.top();
        sb.append(val + ",");
        val = minStack.getMin();
        sb.append(val + ",");
        minStack.push(-2147483648);
        sb.append("null,");
        val = minStack.top();
        sb.append(val + ",");
        val = minStack.getMin();
        sb.append(val + ",");
        minStack.pop();
        sb.append("null,");
        val = minStack.getMin();
        sb.append(val + "]");
        System.out.println(sb.toString());
    }
}
