package com.joyner.algorithm.mashibing_primary.vo;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class Node<V> {
    public V val;
    public Node<V> next;
    public Node<V> random;

    public Node() {

    }
    public Node(V val) {
        this.val = val;
    }

    public Node<V> getNext() {
        return next;
    }

    public void setNext(Node<V> next) {
        this.next = next;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    public Node<V> getRandom() {
        return random;
    }

    public void setRandom(Node<V> random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}