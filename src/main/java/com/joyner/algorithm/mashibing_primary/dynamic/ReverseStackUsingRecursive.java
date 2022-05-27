package com.joyner.algorithm.mashibing_primary.dynamic;

import java.util.Stack;

/**
 * <pre>
 *
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
public class ReverseStackUsingRecursive {

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        //1.弹出栈的最后一个值
        int lastOfStack = getLastOfStack(stack);
        reverse(stack);
        stack.push(lastOfStack);
    }


    public int getLastOfStack(Stack<Integer> stack) {
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        }
        int last = getLastOfStack(stack);
        stack.push(pop);
        return last;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        ReverseStackUsingRecursive reverseStackUsingRecursive = new ReverseStackUsingRecursive();
        reverseStackUsingRecursive.reverse(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }

}
