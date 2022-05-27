package com.joyner.algorithm.mashibing_primary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * <pre>
 * 通过栈来实现队列。<br>
 *     两个栈，一个push，一个pop。
 * </pre>
 *
 * @author 陆清云 luqy
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class MyQueueV3ByStack {

    private LinkedList<Integer> pushStack = new LinkedList<>();

    /**
     *  弹出栈只有为空是才能从pushStack倒入过来
     */
    private LinkedList<Integer> popStack = new LinkedList<>();


    private void pushStackToPopStack() {
        while (!pushStack.isEmpty()) {
            Integer pop = pushStack.pop();
            popStack.push(pop);
        }
    }


    public void offer(int element) {
        pushStack.push(element);
        if (popStack.isEmpty()) {
            pushStackToPopStack();
        }
    }


    public int poll() {
        if (popStack.isEmpty()) {
            pushStackToPopStack();
        }
        Integer pop = popStack.pop();
        return pop;
    }


    public static void main(String[] args) {
        MyQueueV3ByStack myQueueV3ByStack = new MyQueueV3ByStack();
        Queue<Integer> queue = new LinkedList<>();
       /* myQueueV3ByStack.offer(1);
        myQueueV3ByStack.offer(2);
        myQueueV3ByStack.offer(3);
        myQueueV3ByStack.offer(4);

        System.out.println(myQueueV3ByStack.poll());
        System.out.println(myQueueV3ByStack.poll());
        System.out.println(myQueueV3ByStack.poll());
        System.out.println(myQueueV3ByStack.poll());*/


        //写对数器验证
        int maxVal = 100000;
        int testTimes = 100000;
        int maxLen = 100;
        for (int i = 0; i < testTimes; i++) {
            int randomLen = RandomGenerator.generateRandomIntWithoutNegative(maxLen);
            for (int j = 0; j < randomLen; j++) {
                int val = RandomGenerator.generateRandomInt(maxVal);
                myQueueV3ByStack.offer(val);
                queue.offer(val);
            }

            for (int j = 0; j < randomLen; j++) {
                int r1 = myQueueV3ByStack.poll();
                Integer r2 = queue.poll();
                if (r1 != r2) {
                    throw new RuntimeException("fucked.");
                }
            }
        }

        System.out.println("nice good boy!");

    }
}
