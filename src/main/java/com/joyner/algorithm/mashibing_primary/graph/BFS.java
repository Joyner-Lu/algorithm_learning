package com.joyner.algorithm.mashibing_primary.graph;

import java.util.*;

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
public class BFS {

    /**
     * 给定一个节点，对图进行宽带优先遍历<br>
     *     1.进入队列的节点需要登记
     *
     * @param randomNode
     */
    public static void bfs(Node randomNode) {
        if (randomNode == null) {
            return;
        }
        Queue<Node> queue = new LinkedList();
        queue.offer(randomNode);
        //是否打印过
        Set<Node> set = new HashSet<>();
        //需要进行登记
        set.add(randomNode);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println("val:" + poll.getValue());
            List<Node> nextList = poll.getNextList();
            for (int i = 0; i < nextList.size(); i++) {
                Node node = nextList.get(i);
                if (!set.contains(node)) {
                    queue.offer(node);
                    set.add(node);
                }
            }
        }
    }
}
