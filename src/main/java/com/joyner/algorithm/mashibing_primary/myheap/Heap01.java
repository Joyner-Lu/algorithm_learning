package com.joyner.algorithm.mashibing_primary.myheap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <pre>
 * 默认小根堆
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
public class Heap01<T> {

    private ArrayList<T> heap = new ArrayList<>();
    private int limit = INFINITE_SIZE;
    private Comparator<T> comparator;

    /**
     * 不限制大小
     */
    private final static int INFINITE_SIZE = -1;

    public Heap01(int limit) {
        this.limit = limit;
    }

    public Heap01() {
    }

    public Heap01(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * 加入到最后一个位置，然后从最后一个位置往上看，
     *
     * @param value
     */
    public void offer(T value) {
        if (limit != INFINITE_SIZE && size() == limit) {
            throw new RuntimeException("heap is full, limit:" + limit);
        }
        heap.add(value);
        if (comparator == null) {
            heapInsertComparable(size() - 1);
        } else {
            heapInsertComparator(size() - 1);
        }
    }

    public T peak() {
        return isEmpty() ? null : heap.get(0);
    }

    private void heapInsertComparator(int lastIdx) {
        //1.找到父节点
        int parentIdx = (lastIdx - 1) / 2;

        //2.比较
        while (comparator.compare(heap.get(lastIdx), heap.get(parentIdx)) < 0) {
            swap(lastIdx, parentIdx);
            //当前位置变成value
            lastIdx = parentIdx;
            parentIdx = (lastIdx - 1) / 2;
        }
    }

    private void heapInsertComparable(int lastIdx) {
        //1.找到父节点
        int parentIdx = (lastIdx - 1) / 2;

        //2.比较
        Comparable lastComparable = (Comparable)heap.get(lastIdx);

        while (lastComparable.compareTo(heap.get(parentIdx)) < 0) {
            swap(lastIdx, parentIdx);
            //当前位置变成value
            lastIdx = parentIdx;
            parentIdx = (lastIdx - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i,  heap.get(j));
        heap.set(j, temp);
    }

    /**
     * 1.先把第一个位置抓住
     * 2.heapSize--
     * 3.做heapify<br>
     *     2.1 把最后一个位置的数放到0位置
     *     2.2 拿到左右孩子，比较左右孩子的值，拿到大的那个bigger
     *     2.3 和bigger比较，如果小于，交换，如此往复，相当于往下沉
     *
     * @return
     */
    public T  poll() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty!");
        }
        T result = heap.get(0);
        swap(0, size() - 1);
        //移除最后一个原素
        heap.remove(size() - 1);
        if (comparator == null) {
            heapifyComparable(0);
        } else {
            heapifyComparator(0);
        }
        return result;
    }

    /**
     * 从i位置进行堆化
     *
     * @param i
     */
    private void heapifyComparable(int i) {
        if (isEmpty()) {
            return;
        }
        int leftIdx = 2*i + 1;
        int rightIdx = leftIdx + 1;
        while (leftIdx < size()) {

            int smallIdx = rightIdx < size() && ((Comparable)heap.get(rightIdx)).compareTo(heap.get(leftIdx)) < 0 ? rightIdx : leftIdx;
            Comparable iComparable = (Comparable)heap.get(i);
            if (iComparable.compareTo(heap.get(smallIdx)) > 0) {
                //往下沉
                swap(i, smallIdx);
                i = smallIdx;
                leftIdx = 2*i + 1;
                rightIdx = leftIdx + 1;
            } else {
                break;
            }
        }
    }

    private void heapifyComparator(int i) {
        if (isEmpty()) {
            return;
        }
        int leftIdx = 2*i + 1;
        int rightIdx = leftIdx + 1;
        while (leftIdx < size()) {
            int smallIdx = rightIdx < size() && comparator.compare(heap.get(rightIdx), heap.get(leftIdx)) < 0 ? rightIdx : leftIdx;
            if (comparator.compare(heap.get(i), heap.get(smallIdx)) > 0) {
                //往下沉
                swap(i, smallIdx);
                i = smallIdx;
                leftIdx = 2*i + 1;
                rightIdx = leftIdx + 1;
            } else {
                break;
            }
        }
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return limit != INFINITE_SIZE && size() == limit;
    }

    public static void main(String[] args) {

        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            Heap01<Integer> my = new Heap01();
            PriorityQueue<Integer> test = new PriorityQueue<>();
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops!");
                }

                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.offer(curValue);
                    test.add(curValue);
                } else if (my.isFull()) {
                    if (!my.poll().equals(test.poll())) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.offer(curValue);
                        test.add(curValue);
                    } else {
                        if (!my.poll().equals(test.poll())) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");


    }
}
