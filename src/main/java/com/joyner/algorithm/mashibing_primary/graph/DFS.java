package com.joyner.algorithm.mashibing_primary.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * <pre>
 *
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
public class DFS {

    /**
     * 1.进栈就打印
     * 2.弹出栈里面的元素A，如果该元素有子元素,则把A放回去，把未处理过的元素入栈，然后break.
     *
     * @param randomNode
     */
    public static void dfs(Node randomNode) {
        if (randomNode == null) {
            return;
        }
        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        System.out.println(randomNode.getValue());
        stack.push(randomNode);
        set.add(randomNode);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            List<Node> nextList = pop.getNextList();
            for (int i = 0; i < nextList.size(); i++) {
                Node node = nextList.get(i);
                if (!set.contains(node)) {
                    System.out.println(node.getValue());
                    //父节点先进入栈
                    stack.push(pop);
                    stack.push(node);
                    break;
                }
            }
        }
    }
}
