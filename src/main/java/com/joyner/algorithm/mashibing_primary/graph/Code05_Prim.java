package com.joyner.algorithm.mashibing_primary.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

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
public class Code05_Prim {

    public static Set<Edge> primMST(Graph graph) {
        //被解锁的点集
        Set<Node> nodeSet = new HashSet<>();
        //被解锁的边集
        Set<Edge> edgeSet = new HashSet<>();

        Set<Edge> result = new HashSet<>();

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        /**
         * 1.从任意一点出发，解锁该点的直接边，放入edgeSet
         * 2.把这些边放入到小根堆里面（不在edgeSet才放入）
         * 3.堆非空从小根堆里面弹出边，获取to点，如果to点在nodeSet里面，不要该边<br>
         *     否则要该边，并把to节点的所有边进行解锁，放入小根堆里面，重复3的步骤
         */
        for(Node fromNode : graph.getNodeMap().values()) {
            nodeSet.add(fromNode);
            List<Edge> edgeList = fromNode.getEdgeList();
            for (Edge edge : edgeList) {
                edgeSet.add(edge);
                priorityQueue.add(edge);
            }

            while (!priorityQueue.isEmpty()) {
                //非空
                Edge pollEdge = priorityQueue.poll();
                Node toNode = pollEdge.getTo();
                if (!nodeSet.contains(toNode)) {
                    nodeSet.add(toNode);
                    //要这条边
                    result.add(pollEdge);
                }
                //解锁toNode节点的其他边
                List<Edge> edgeList1 = toNode.getEdgeList();
                for (Edge edge : edgeList1) {
                    if (!edgeSet.contains(edge)) {
                        edgeSet.add(edge);
                        priorityQueue.add(edge);
                    }
                }
            }
            //获取随机的点然后break跳出，防止森林
            break;
        }
        return result;
    }
}
