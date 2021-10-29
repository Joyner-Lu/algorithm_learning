package com.joyner.algorithm.mashibing_primary.graph;

import java.util.Map;
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
public class GraphGenerator {

    // matrix 所有的边
    // N*3 的矩阵
    // [weight, from节点上面的值，to节点上面的值]
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        Map<Integer, Node> nodeMap = graph.getNodeMap();
        Set<Edge> edgeSet = graph.getEdgeSet();
        for (int i = 0; i < matrix.length; i++) {
            Integer[] nodeData = matrix[i];
            int from = nodeData[1];
            int to = nodeData[2];
            int weight = nodeData[0];

            Node fromNode = nodeMap.get(from);
            //判断是否该点被建立过
            if (fromNode == null) {
                fromNode = new Node();
                fromNode.setValue(from);
                nodeMap.put(from, fromNode);
            }

            Node toNode = nodeMap.get(to);
            if (toNode == null) {
                toNode = new Node();
                toNode.setValue(to);
                nodeMap.put(to, toNode);
            }

            //构建一条边
            Edge edge = new Edge();
            edge.setWeight(weight);
            edge.setFrom(fromNode);
            edge.setTo(toNode);

            //给图设置边集合
            graph.getEdgeSet().add(edge);
            //设置from
            fromNode.setOut(fromNode.getOut() + 1);
            fromNode.getNextList().add(toNode);
            fromNode.getEdgeList().add(edge);

            //设置to
            toNode.setIn(toNode.getIn() + 1);

        }

        return graph;
    }
}
