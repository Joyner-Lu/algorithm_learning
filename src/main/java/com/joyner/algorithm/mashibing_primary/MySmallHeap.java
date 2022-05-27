package com.joyner.algorithm.mashibing_primary;

import com.joyner.common.util.collection.ArrUtils;

/**
 * <pre>
 * 小根堆。<br>
 *     小根堆就是每一个树都满足根的值是最小的一个完全二叉树。
 *
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
public class MySmallHeap {

    /**
     * 堆当前的大小
     */
    private int heapSize = 0;

    /**
     * 堆的容量
     */
    private int limit = 0;

    private int[] heap;

    public MySmallHeap(int limit) {
        this.limit = limit;
        heap = new int[limit];
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * 构建小根堆
     *
     * @param val
     */
    public void push(int val) {
        if (heapSize == limit) {
            throw new RuntimeException("堆已满！");
        }
        //直接在末位置添加
        heap[heapSize++] = val;
        //调整使其成为小根堆
        heapInsert(heap, heapSize -1);

    }

    public int pop() {
        int ans = heap[0];
        //把末尾数和根节点交换
        //且heapSize减一，也就是末位数已经无效。（即使他存在）
        ArrUtils.swap(heap, 0, --heapSize);
        //进行堆化，往下看
        heapify(heap, 0);

        return ans;
    }

    /**
     * 从当前节点往下看他的左孩子和右孩子，找最小的那个，然后交换。如此往复
     *
     * @param heap
     * @param curIdx
     */
    private void heapify(int[] heap, int curIdx) {
        int leftIdx = 2*curIdx + 1;
        int rightIdx = leftIdx + 1;
        while (leftIdx < heapSize) {
            //左孩子和右孩子pk
            int largestIdx = rightIdx < heapSize && heap[rightIdx] < heap[leftIdx] ? rightIdx : leftIdx;
            //largest和当前pk
            if (heap[curIdx] > heap[largestIdx]) {
                //交换
                ArrUtils.swap(heap, largestIdx, curIdx);
                //重新计算左右孩子
                curIdx = largestIdx;
                leftIdx = 2*curIdx + 1;
                rightIdx = leftIdx + 1;
            } else {
                break;
            }
        }
    }

    /**
     * 调整的流程，往上看，找父节点，如果父节点的值小于当前值，交换，否则停止。
     * 如此往复，一直到根节点
     *
     * @param heap
     * @param curIdx
     */
    private void heapInsert(int[] heap, int curIdx) {
        //1.获取父索引
        int pIdx = (curIdx - 1) / 2;
        //当前位置比父亲小，则继续往上看
        while (heap[pIdx] > heap[curIdx]) {
            ArrUtils.swap(heap, curIdx, pIdx);
            curIdx = pIdx;
            pIdx = (curIdx - 1) / 2;
        }
    }


    public static void main(String[] args) {
        MySmallHeap myBigHeap = new MySmallHeap(10);
        myBigHeap.push(3);
        myBigHeap.push(8);
        myBigHeap.push(9);
        myBigHeap.push(10);
        myBigHeap.push(11);
        myBigHeap.push(-1);
        myBigHeap.push(18);

        myBigHeap.pop();
        System.out.println();


    }

}
