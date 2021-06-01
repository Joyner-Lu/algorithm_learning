package com.joyner.algorithm.mashibing_primary;

/**
 * <pre>
 * 完全二叉树，使用数组来实现,如下图所示<br>
*            0
 *       1       2
 *     3   4   5    6
 *
 * 发现索引i的左孩子就是：2*i + 1,右孩子：2*i + 2,  父节点 (i - 1) / 2
 * 原理：完全二叉树每一层的数量翻倍，数量从1，2，4，8，16...这样的方式增长，因此乘以2
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
public class MyCompleteTwoForkTree {

    private int capacity = 0;
    private int size = 0;
    private int[] tree;

    public MyCompleteTwoForkTree(int capacity) {
        this.capacity = capacity;
        tree = new int[capacity];
    }


    public void push(int val) {
        if (size == capacity) {
            throw new RuntimeException("完全二叉树的容量已经满了");
        }
        tree[size++] = val;
    }

    public static void main(String[] args) {
        MyCompleteTwoForkTree myCompleteTwoForkTree = new MyCompleteTwoForkTree(10);
        myCompleteTwoForkTree.push(3);
        myCompleteTwoForkTree.push(4);
        myCompleteTwoForkTree.push(2);
        myCompleteTwoForkTree.push(5);
        myCompleteTwoForkTree.push(7);
        System.out.println();
    }
}
