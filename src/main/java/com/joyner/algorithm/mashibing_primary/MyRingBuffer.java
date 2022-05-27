package com.joyner.algorithm.mashibing_primary;

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
public class MyRingBuffer {

    private int cycleSize;
    private int[] buffer;
    private int idx = 0;

    public MyRingBuffer(int cycleSize) {
        this.cycleSize = cycleSize;
        //循环的数量
        buffer = new int[cycleSize];
    }


    public void put(int val) {
        buffer[idx] = val;
        idx = ++idx == buffer.length ? 0 : idx;
    }

    private int curIdx() {
        return idx;
    }


}
