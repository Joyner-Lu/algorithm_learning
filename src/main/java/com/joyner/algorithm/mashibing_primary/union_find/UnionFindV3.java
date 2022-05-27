package com.joyner.algorithm.mashibing_primary.union_find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * <pre>
 *
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
public class UnionFindV3<V> implements IUnionFind<V> {

    class Node<V> {

        V value;

        public Node(V v) {
            this.value = value;
        }

    }

    /**
     * 节点映射表
     */
    private Map<V, Node<V>> nodeMap = new HashMap<>();

    /**
     * 父子节点表
     */
    private Map<Node<V>, Node<V>> fatherMap = new HashMap<>();

    /**
     * 大小map
     */
    private Map<Node<V>, Integer> sizeMap = new HashMap<>();

    public UnionFindV3() {}

    public UnionFindV3(List<V> elements) {
        /**
         * 初始化
         */
        for(V element : elements) {
            Node<V> newNode = new Node<>(element);
            nodeMap.put(element, newNode);
            //初始化状态，每个都是自己的代表点
            fatherMap.put(newNode, newNode);
            //初始状态，每个集合的点都为1
            sizeMap.put(newNode, 1);
        }
    }



    @Override
    public boolean isSameSet(V a, V b) {
        /**
         * 1.判断是否存在nodeMap
         * 2.找father,拿到代表点，如果代表点一样返回true,否则返回false
         */
        Node<V> aNode = nodeMap.get(a);
        Node<V> bNOde = nodeMap.get(b);
        if (aNode == null || bNOde == null) {
            return false;
        }

        Node<V> aPresent = findFather(aNode);
        Node<V> bPresent = findFather(bNOde);
        return aPresent == bPresent;

    }

    private Node<V> findFather(Node<V> node) {

        Stack<Node<V>> stack = new Stack<>();

        Node<V> pNode = fatherMap.get(node);
        while (pNode != node) {
            stack.push(node);
            //继续往上找
            node = pNode;
            pNode = fatherMap.get(node);
        }

        //扁平化处理
        while (!stack.isEmpty()) {
            Node<V> pop = stack.pop();
            fatherMap.put(pop, pNode);
        }

        return pNode;
    }

    @Override
    public void union(V a, V b) {
        /**
         * 1.判断是否在集合里面
         * 2.判断代表点是否一致，如果一致，不需要合并
         * 3.代表点不一致，小挂大
         */
        Node<V> aNode = nodeMap.get(a);
        Node<V> bNOde = nodeMap.get(b);
        if (aNode == null || bNOde == null) {
            return;
        }
        Node<V> aPresent = findFather(aNode);
        Node<V> bPresent = findFather(bNOde);
        if (aPresent != bPresent) {
            //小挂大
            Integer aPresentSize = sizeMap.get(aPresent);
            Integer bPresentSize = sizeMap.get(bPresent);
            if (aPresentSize < bPresentSize) {
                //a去挂b
                fatherMap.put(aPresent, bPresent);
                sizeMap.remove(aPresent);
            } else {
                fatherMap.put(bPresent, aPresent);
                sizeMap.remove(bPresent);
            }

        }


    }

    @Override
    public void add(V value) {
        /**
         * 1.判断是否已经存在，如果存在略过
         * 2.加入到并查集里面
         */
        if (nodeMap.get(value) != null) {
            return;
        }

        Node<V> newNode = new Node<>(value);
        nodeMap.put(value, newNode);
        //初始化状态，每个都是自己的代表点
        fatherMap.put(newNode, newNode);
        //初始状态，每个集合的点都为1
        sizeMap.put(newNode, 1);
    }


    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        List<String> samples = new ArrayList<>();
        samples.add(a);
        samples.add(b);
        samples.add(c);
        IUnionFind<String> unionFindV2 = new UnionFindV3(samples);


        System.out.println(unionFindV2.isSameSet(b, c));
        boolean sameSet = unionFindV2.isSameSet(c, c);
        System.out.println(sameSet);
        unionFindV2.union(a, b);
        System.out.println(unionFindV2.isSameSet(a, b));
        unionFindV2.union(a, c);
        System.out.println(unionFindV2.isSameSet(b, c));
        System.out.println();
        unionFindV2.union(a, b);
    }


}
