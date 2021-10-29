package com.joyner.algorithm.mashibing_primary.graph;

import com.joyner.algorithm.mashibing_primary.union_find.IUnionFind;
import com.joyner.algorithm.mashibing_primary.union_find.UnionFindV3;

import java.util.Comparator;
import java.util.HashSet;
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
public class Kruskal {

    public static Set<Edge> kruskalMST(Graph graph) {
        /**
         * 1.获取所有的边，放入小根堆里面
         * 2.弹出推顶的值，如果这条边的from 和to不是同一个集合，要这条边，继续处理2，知道为空
         */
        IUnionFind<Node> unionFind = new UnionFindV3();

        Set<Edge> result = new HashSet<>();

        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        for(Edge edge : graph.getEdgeSet()) {
            queue.add(edge);
            unionFind.add(edge.getFrom());
            unionFind.add(edge.getTo());
        }

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            Node from = poll.getFrom();
            Node to = poll.getTo();
            boolean sameSet = unionFind.isSameSet(from, to);
            if (!sameSet) {
                result.add(poll);
            }

        }
        return result;
    }
}
