package com.joyner.algorithm.mashibing_primary.graph;

import com.joyner.algorithm.mashibing_primary.graph.DijkstraV2.NodeHeap.NodeRecord;

import java.util.ArrayList;
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
public class DijkstraV2 {

    /**
     * 1.实现一个小根堆（按从from到该节点的distance来排序）
     *
     * @param from
     * @return 返回的是一个表，该表的所有点都是相对于from点的最小距离
     *
     */
    public Map<Node, Integer> dijkstra2(Node from) {
        Map<Node, Integer> result = new HashMap<>();
        NodeHeap nodeHeap = new NodeHeap();
        nodeHeap.addOrUpdateOrIgnore(from, 0);
        while (!nodeHeap.isEmpty()) {
            NodeRecord pop = nodeHeap.pop();
            Node node = pop.node;
            List<Edge> edgeList = node.getEdgeList();
            for (Edge edge : edgeList) {
                Node to = edge.getTo();
                nodeHeap.addOrUpdateOrIgnore(to, pop.distance + edge.getWeight());
            }
            result.put(node, pop.distance);
        }

        return result;
    }


    class NodeHeap {

        private final static int OUT_HEAP = -1;

        /**
         * 堆
         */
        private List<Node> heap = new ArrayList<>();

        /**
         * 节点在堆上的索引位置,如果索引为-1，则表明曾经进过堆，但是此时已经不在堆上面
         */
        private Map<Node, Integer> heapIdxMap = new HashMap<>();

        /**
         * 记录该节点到from节点的距离
         */
        private Map<Node, Integer> distanceMap = new HashMap<>();

        /**
         * 是否进过堆
         *
         * @param node
         * @return
         */
        public boolean isEntered(Node node) {
            return heapIdxMap.containsKey(node);
        }

        /**
         * 是否在堆上
         *
         * @param node
         * @return
         */
        public boolean isInHeap(Node node) {
            return heapIdxMap.containsKey(node) && (heapIdxMap.get(node) != OUT_HEAP);
        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        public int size() {
            return heap.size();
        }

        /**
         * 1.add
         * 2.update <br>
         *
         * @param node
         * @param newDistance
         */
        public void addOrUpdateOrIgnore(Node node, int newDistance) {
            /**
             * 1.如果heapIdxMap不存在，则add
             * 2.如果在堆上则update
             * 3.除了1和2都忽略
             */
             if (!isEntered(node)) {
                 //add
                 /**
                  * 放入到最后一个节点，然后做heapInsert
                  */
                 int idx = heap.size();
                 heapIdxMap.put(node, idx);
                 distanceMap.put(node, newDistance);
                 //size自动增加
                 heap.add(node);
                 heapInsert(idx);
             } else if (isInHeap(node)) {
                 //update
                 distanceMap.put(node, Math.min(distanceMap.get(node), newDistance));
                 int nodeIdx = heapIdxMap.get(node);
                 heapify(nodeIdx);
             }
        }

        public int getDistance(int idx) {
            return distanceMap.get(heap.get(idx));
        }

        /**
         * 从idx位置开始堆化（向下）
         *
         * @param idx
         */
        private void heapify(int idx) {
            int leftIdx = 2 * idx + 1;
            int rightIdx = leftIdx + 1;
            while (leftIdx < size()) {
                int smallIdx = rightIdx < size() && getDistance(rightIdx) < getDistance(leftIdx) ? rightIdx : leftIdx;
                if (getDistance(idx) > getDistance(smallIdx)) {
                    //比最小的还大，交换
                    swap(idx, smallIdx);
                    //continue
                    idx = smallIdx;
                    leftIdx = 2 * idx + 1;
                    rightIdx = leftIdx + 1;
                } else {
                    break;
                }
            }

        }

        /**
         * 从最后一个位置往看
         *
         * @param idx
         */
        private void heapInsert(int idx) {
            int pIdx = (idx - 1) / 2;
            Node node = heap.get(idx);
            Node pNode = heap.get(pIdx);

            while (distanceMap.get(pNode) > distanceMap.get(node)) {
                swap(idx, pIdx);
                //continue
                idx = pIdx;
                pIdx = (idx - 1) / 2;
                node = heap.get(idx);
                pNode = heap.get(pIdx);
            }
        }

        /**
         * 弹出
         *
         * @return
         */
        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord();
            nodeRecord.node = heap.get(0);
            nodeRecord.distance = distanceMap.get(heap.get(0));
            //最后一个元素和第一个元素交换
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            //最后进行堆化（注意需要先删除，保证堆化的长度是正确的）
            heapify(0);
            return nodeRecord;
        }

        private void swap(int i, int j) {
            //1.调整索引
            heapIdxMap.put(heap.get(i), j);
            heapIdxMap.put(heap.get(j), i);

            //2.交换位置
            Node temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        class NodeRecord {
            Node node;
            Integer distance;
        }
    }

}
