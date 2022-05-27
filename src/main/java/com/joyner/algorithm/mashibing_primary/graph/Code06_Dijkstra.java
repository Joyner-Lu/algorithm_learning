package com.joyner.algorithm.mashibing_primary.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <pre>
 * 1）Dijkstra算法必须指定一个源点
 * 2）生成一个源点到各个点的最小距离表，一开始只有一条记录，即原点到自己的最小距离为0，源点到其他所有点的最小距离都为正无穷大
 * 3）从距离表中拿出没拿过记录里的最小记录，通过这个点发出的边，更新源点到各个点的最小距离表，不断重复这一步
 * 4）源点到所有的点记录如果都被拿过一遍，过程停止，最小距离表得到了
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
public class Code06_Dijkstra {

    /**
     *
     *
     * @param from
     * @return 返回的是一个表，该表的所有点都是相对于from点的最小距离
     *
     */
    public static Map<Node, Integer> dijkstra1(Node from) {
        Map<Node, Integer> distance = new HashMap<>();
        distance.put(from, 0);
        //获取from的直接边
        Set<Node> lockedNodeSet = new HashSet<>();
        //获取未锁住的最小的节点
        Node minNode = getMinAndUnLockedNode(distance, lockedNodeSet);
        while (minNode != null) {
            Integer distanceVal = distance.get(minNode);
            //获取该节点的直接邻居
            List<Edge> edgeList = minNode.getEdgeList();
            for (Edge edge : edgeList) {
                Node node = edge.getTo();
                if (distance.containsKey(node)) {
                    //已经存在，则看下是否可以更新该值
                    distance.put(node, Math.min(distance.get(node), distanceVal + edge.getWeight()));
                } else {
                    distance.put(node, distanceVal + edge.getWeight());
                }
            }
            lockedNodeSet.add(minNode);
            //继续下一轮处理
            minNode = getMinAndUnLockedNode(distance, lockedNodeSet);

        }
        return distance;

    }

    private static Node getMinAndUnLockedNode(Map<Node, Integer> distance, Set<Node> lockedNodeSet) {
        Node minNode = null;
        Integer minVal = Integer.MAX_VALUE;
        Set<Entry<Node, Integer>> entries = distance.entrySet();
        for (Entry<Node, Integer> entry : entries) {
            if (lockedNodeSet.contains(entry.getKey())) {
                //该记录已经被锁住了，继续处理
                continue;
            }
            if (entry.getValue() < minVal) {
                minVal = entry.getValue();
                minNode = entry.getKey();
            }
        }
        return minNode;
    }
}
