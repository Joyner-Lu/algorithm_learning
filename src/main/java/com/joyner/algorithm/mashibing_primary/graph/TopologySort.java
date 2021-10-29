package com.joyner.algorithm.mashibing_primary.graph;

import java.util.*;

/**
 * <pre>
 * 图的拓扑排序，例如：
 *
 *
 * A-->B--->C--->E--->F
 * A------->C
 *          C--->T
 *          F--->T
 *
 * 也就是B需要等到A先做，C等到B先做，C等到A先做，E等到C先做，F等到E先做
 * T要等到C和F先做先做，打印的顺序就是：
 * A,B,C,E,F, T
 * 这个就是图的拓扑排序，应用场景就是编译器
 *
 * 备注：必须是有向无环图
 *
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
public class TopologySort {

    /**
     * 1.找入度为0的节点，打印
     * 2.消除直接邻居的入度，继续第1步，如此重复
     *
     * @param graph
     * @return
     */
    public static List<Node> sortedTopology(Graph graph) {
        List<Node> result = new ArrayList<>();

        //1.准备一个map<node,int>   节点和入度的对应关系，除此之外还要准备一个队列，放入度为0的节点
        //2.遍历图，初始化map，把入度为0的节点放入到队列里面
        //3.如果队列非空处理队列，弹出，消除其直接邻居的入度。
        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroQueue = new LinkedList<>();

        Collection<Node> values = graph.getNodeMap().values();
        for(Node node : values) {
            inMap.put(node, node.getIn());
            if (node.getIn() == 0) {
                zeroQueue.offer(node);
            }
        }

        while (!zeroQueue.isEmpty()) {
            Node poll = zeroQueue.poll();
            result.add(poll);
            for(Node node : poll.getNextList()) {
                Integer in = inMap.get(node);
                Integer newIn = in - 1;
                inMap.put(node, newIn);
                if (newIn == 0) {
                    zeroQueue.offer(node);
                }
            }
        }

        return result;

    }

}
