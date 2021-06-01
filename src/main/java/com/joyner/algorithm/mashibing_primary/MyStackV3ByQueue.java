package com.joyner.algorithm.mashibing_primary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 栈，使用两个队列实现<br>
 *     要弹出的时候，先导入到help,直到剩最后一个。然后help变queue，queue变help
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
public class MyStackV3ByQueue {

    private Queue<Integer> queue = new LinkedList();
    private Queue<Integer> help = new LinkedList<>();


    public void push(Integer pushVal) {
        queue.offer(pushVal);
    }


    public int pop() {
        while (!queue.isEmpty() && queue.size() > 1) {
            Integer poll = queue.poll();
            help.offer(poll);
        }

        //取最后一个
        Integer ans = queue.poll();



        //help变queue, queue变help
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;

        return ans;
    }


    public static void main(String[] args) {
        MyStackV3ByQueue myStackV3ByQueue = new MyStackV3ByQueue();
        myStackV3ByQueue.push(3);
        myStackV3ByQueue.push(2);
        myStackV3ByQueue.push(1);
        System.out.println(myStackV3ByQueue.pop());
        myStackV3ByQueue.push(13);
        System.out.println(myStackV3ByQueue.pop());

        System.out.println(myStackV3ByQueue.pop());

        System.out.println(myStackV3ByQueue.pop());


    }

}
