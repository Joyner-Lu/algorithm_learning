package com.joyner.algorithm.mashibing_primary;

import javax.management.relation.RoleUnresolved;

/**
 * <pre>
 * 使用数组实现的队列，且限制容量
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
public class MyQueueV2 {

    private int capacity;
    private int size;
    private int putIdx;
    private int getIdx;
    private int[] datas;

    public MyQueueV2(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("容量不能小于等于0");
        }
        this.capacity = capacity;
        datas = new int[capacity];
        this.putIdx = 0;
        this.getIdx = 0;
    }


    public void offer(int val) {
        if (size == capacity) {
            throw new RuntimeException("容量已满");
        }
        datas[putIdx] = val;
        //判断往下一个位置是否超了容量，如果超了，则置为0，否则返回putIdx
        putIdx = ++putIdx == capacity ? 0 : putIdx;
        size++;
    }


    public int poll() {
        if (size == 0) {
            throw new RuntimeException("没有数据");
        }
        int ans = datas[getIdx];
        getIdx = ++getIdx == capacity ? 0 : getIdx;
        size--;
        return ans;
    }


    public static void main(String[] args) {
        MyQueueV2 myQueueV2 = new MyQueueV2(3);
        myQueueV2.offer(3);
        myQueueV2.offer(5);
        myQueueV2.offer(6);

        System.out.println(myQueueV2.poll());
        System.out.println(myQueueV2.poll());
        System.out.println(myQueueV2.poll());
        myQueueV2.offer(4);
        myQueueV2.offer(6);
        System.out.println(myQueueV2.poll());
        System.out.println(myQueueV2.poll());
        System.out.println(myQueueV2.poll());
    }


}
