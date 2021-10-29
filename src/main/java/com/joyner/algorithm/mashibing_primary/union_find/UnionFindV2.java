package com.joyner.algorithm.mashibing_primary.union_find;

import com.sun.org.apache.regexp.internal.RE;

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
public class UnionFindV2<V> {

    /**
     * 记录map.
     * 记录v和node<v>的对应关系
     */
    private Map<V,Node<V>> recordMap = new HashMap<>();

    /**
     * 父map
     */
    private Map<Node<V>, Node<V>> fatherMap = new HashMap<>();

    /**
     * sizeMap.
     * 备注：只有代表点在size map里面有记录
     */
    private Map<Node<V>, Integer> sizeMap = new HashMap<>();

    public UnionFindV2(List<V> samples) {
        for (V v : samples) {
            Node<V> node = new Node<>(v);
            recordMap.put(v, node);
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }



    /**
     * 为true的条件
     * 1.a和b必须都在recordMap里面
     * 2.通过fatherMap找到的代表点，必须是同一个点
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isSameSet(V a, V b) {
        if (!recordMap.containsKey(a) || !recordMap.containsKey(b)) {
            return false;
        }

        Node<V> aPresent = findFather(recordMap.get(a));
        Node<V> bPresent = findFather(recordMap.get(b));
        return aPresent == bPresent;
    }

    /**
     * 1.将vNode赋值给cur
     * 2.去fatherMap找cur的父节点，如果父节点和cur相等，返回cur
     * 3.如果不相等，把父节点给cur继续2的过程
     *
     * @param vNode
     * @return
     */
    private Node<V> findFather(Node<V> vNode) {
        Stack<Node<V>> stack = new Stack<>();
        Node<V> cur = vNode;
        while (cur != fatherMap.get(cur)) {
            stack.push(cur);
            cur = fatherMap.get(cur);
        }

        //对father进行扁平化处理
        while (!stack.isEmpty()) {
            Node<V> pop = stack.pop();
            fatherMap.put(pop, cur);
        }

        return cur;
    }


    /**
     * 1.如果a和b不在recordMap里面，不做任何操作
     * 2.找到a和b的代表点，如果代表点相同，不做任何操作
     * 3.从sizeMap里面获取代表点的size。
     * 3.如果a的代表点的size大于b。则用b去挂a，并且把b从size map里面移除
     *
     * @param a
     * @param b
     */
    public void union(V a, V b) {
        if (!recordMap.containsKey(a) || !recordMap.containsKey(b)) {
            return;
        }

        Node<V> aPresent = findFather(recordMap.get(a));
        Node<V> bPresent = findFather(recordMap.get(b));
        if (aPresent != bPresent) {
            //默认
            Node<V> bigger = aPresent;
            Node<V> small = bPresent;
            Integer aPresentSize = sizeMap.get(recordMap.get(a));
            Integer bPresentSize = sizeMap.get(recordMap.get(b));

            if (aPresentSize < bPresentSize) {
                //不符合默认值
                bigger = bPresent;
                small = aPresent;
            }

            //设置father
            fatherMap.put(small, bigger);
            sizeMap.remove(small);

        }
    }


    class Node<V> {
        V value;

        Node(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        List<String> samples = new ArrayList<>();
        samples.add(a);
        samples.add(b);
        samples.add(c);
        UnionFindV2<String> unionFindV2 = new UnionFindV2(samples);
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
