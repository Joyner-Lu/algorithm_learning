package com.joyner.algorithm.mashibing_primary.union_find;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * <pre>
 * 并查集算法
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
public class UnionFind<V> {

    class Node<V> {
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    /**
     * V和Node<V>的对应关系
     */
    private Map<V, Node<V>> nodes = new HashMap<>();

    /**
     * Node<V>和父亲节点Node<V>的对应关系
     */
    private Map<Node<V>, Node<V>> parents = new HashMap<>();

    /**
     * 集合代表点的size,注意非代表点一定不在sizeMap里面
     */
    private Map<Node<V>, Integer> sizeMap = new HashMap<>();


    public UnionFind(List<V> values) {
        if (values != null && values.size() > 0) {
            for (int i = 0; i < values.size(); i++) {
                V value = values.get(i);
                Node<V> node = new Node<>(value);

                //放到value和其包装点的map里面
                nodes.put(value, node);
                //当前的父亲就是自己
                parents.put(node, node);
                //代表点的size
                sizeMap.put(node, 1);

            }
        }
    }

    public boolean isSameSet(V a, V b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
            //不包含直接返回false
            return false;
        }
        return findFather(nodes.get(a)) == findFather(nodes.get(b));


    }

    private Node<V> findFather(Node<V> vNode) {
        Stack<Node<V>> stack = new Stack<>();


        Node<V> cur = vNode;
        while (parents.get(vNode) != cur) {
            stack.push(cur);
            cur = parents.get(vNode);
        }

        //扁平化处理。
        while (!stack.isEmpty()) {
            parents.put(stack.pop(), cur);
        }

        return cur;
    }


    public void union(V a, V b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
            //不包含直接返回
            return;
        }

        //都保护了之后，找代表点
        Node<V> aFather = findFather(nodes.get(a));
        Node<V> bFather = findFather(nodes.get(b));

        //获取代表点的大小
        Integer aSize = sizeMap.get(aFather);
        Integer bSize = sizeMap.get(bFather);

        if (aFather != bFather) {
            //非同一个集合才要合并
            if (aSize < bSize) {
                //a小挂到b上面
                parents.put(aFather, bFather);
                sizeMap.put(bFather, aSize + bSize);
                //把a的size移除
                sizeMap.remove(aFather);
            } else {
                //b小挂到a上面
                parents.put(bFather, aFather);
                sizeMap.put(aFather, aSize + bSize);
                //把b的size移除
                sizeMap.remove(bFather);
            }
        }


    }

    public static void main(String[] args) {

    }


}
