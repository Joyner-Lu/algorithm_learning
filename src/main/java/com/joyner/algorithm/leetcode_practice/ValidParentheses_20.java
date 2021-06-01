package com.joyner.algorithm.leetcode_practice;

import java.util.Stack;

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
public class ValidParentheses_20 {

    private Stack<Character> stack = new Stack();

    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char top = stack.peek();
                if (top == '(' && c == ')') {
                    stack.pop();
                } else if (top == '{' && c == '}') {
                    stack.pop();
                } else if (top == '[' && c == ']') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s =    "({[)";
        ValidParentheses_20 validParentheses_20 = new ValidParentheses_20();
        boolean r = validParentheses_20.isValid(s);
        System.out.println(r);
    }
}
