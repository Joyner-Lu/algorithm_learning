package com.joyner.algorithm.mashibing_trainingcamp001.day01;

import java.util.*;

/**
 * <pre>
 * 滑动窗口原则
 * 1.l和r只能往前移动
 * 2.l<=r
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
public class SlidingWindowUtil {

    /**
     * 1.元素从左到右：大->小
     * 2.r移动，右端添加，添加规则：
     * 1）.peekLast, 若 peekLast下标对应的元素的值 小于等于进入窗口的元素的值，则弹出
     * 2）.继续1的流程，直到队列为空或者，进入窗口的元素大于peekLast下标对应的元素的值
     * 3）.将窗口元素的下标添加到队列
     * 例如：arr[3, 5, 7] r->  3进入队列 r->  5进入队列，但是5>3,3弹出，因为在窗口l移动的过程中，3已经不可能成为最大值了（5比3晚过期）
     * 3.l移动，表明该元素过期，从队列左端看是否是过期元素，是则弹出，否则不做任何操作
     * <p>
     * 含义：如果此时形成的窗口状况，不想让r移动，而让l往右动，在双端队列里，谁会依次成为最大值的优先级。
     */
    private Deque<Integer> maxDeque = new LinkedList<>();


    /**
     * 1.元素从左到右：小->大
     */
    private Deque<Integer> minDeque = new LinkedList<>();


    private int[] targetArr;
    /**
     * //[pos0  7-idx0  pos1 , 8-idx1  pos2, 4-idx2  pos3]
     * 返回的是是[l, r)
     */
    private int l = 0;
    /**
     * //最大值是size
     */
    private int r = 0;


    /**
     * 记录长度
     */
    private int size = 0;

    public SlidingWindowUtil(int[] targetArr) {
        this.targetArr = targetArr;
    }

    public SlidingWindowUtil(int[] targetArr, int winSize) {
        this.targetArr = targetArr;
        //形成窗口
        rightForward(winSize);
    }

    public boolean rightForward() {
        if (r < targetArr.length) {
            r++;
            size++;
            updateDequeWhenRightMove(ValType.MAX_VAL);
            updateDequeWhenRightMove(ValType.MIN_VAL);
            return true;
        } else {
            return false;
        }

    }

    public boolean forwardAll() {
        boolean r = rightForward();
        if (r) {
            //确保窗口函数大小不变
            leftForward();
        }
        return r;
    }

    public boolean rightForward(int times) {
        int moveTimes = 0;
        boolean result = false;
        boolean isCanMove = true;
        while (moveTimes < times && isCanMove) {
            isCanMove = rightForward();
            if (isCanMove && moveTimes == 0) {
                //确保更新一次,第一次能移动，那就认为可以移动
                result = true;
            }
            moveTimes++;
        }
        return result;

    }


    public boolean leftForward(int times) {
        int moveTimes = 0;
        boolean result = false;
        boolean isCanMove = true;
        while (moveTimes < times && isCanMove) {
            isCanMove = leftForward();
            if (isCanMove && moveTimes == 0) {
                //确保更新一次,第一次能移动，那就认为可以移动
                result = true;
            }
            moveTimes++;
        }
        return result;

    }

    private enum ValType {
        /**
         * 类型
         */
        MAX_VAL, MIN_VAL
    }

    private void updateDequeWhenRightMove(ValType valType) {
        boolean isMaxType = false;
        Deque<Integer> deque = null;
        switch (valType) {
            case MAX_VAL:
                isMaxType = true;
                deque = maxDeque;
                break;
            case MIN_VAL:
                deque = minDeque;
                break;
            default:
                break;
        }

        //更新双端队列
        if (deque.isEmpty()) {
            deque.addLast(r - 1);
        } else {
            //队列尾部的元素
            int dequeLastElIdx = deque.peekLast();
            while ((isMaxType && targetArr[dequeLastElIdx] <= targetArr[r - 1])
                    || (!isMaxType && targetArr[dequeLastElIdx] >= targetArr[r - 1])) {
                deque.pollLast();//移除掉
                if (deque.isEmpty()) {
                    break;
                }
                dequeLastElIdx = deque.peekLast();

            }
            deque.addLast(r - 1);
        }
    }

    public boolean leftForward() {
        if (l < r) {
            updateDequeWhenLeftMove(ValType.MAX_VAL);
            updateDequeWhenLeftMove(ValType.MIN_VAL);
            l++;
            size--;

            return true;
        } else {
            return false;
        }
    }

    private void updateDequeWhenLeftMove(ValType valType) {
        boolean isMaxValType = false;
        Deque<Integer> deque = null;
        switch (valType) {
            case MAX_VAL:
                isMaxValType = true;
                deque = maxDeque;
                break;
            case MIN_VAL:
                deque = minDeque;
                break;
            default:
                break;
        }

        if (!deque.isEmpty()) {
            int firstIdx = deque.peekFirst();
            if (firstIdx == l) {
                //是过期的，则移除掉
                deque.removeFirst();
            }
        }
    }

    public int[] currentPos() {
        int[] pos = new int[2];
        pos[0] = l;
        pos[1] = r;
        return pos;
    }

    public void printCurrentPos() {
        int[] pos = currentPos();
        System.out.println("left pos:" + pos[0]);
        System.out.println("right pos:" + pos[1]);

    }

    /**
     * 返回滑动窗口的最大值，没有则返回null
     * <p>
     * 利用单调双端队列实现
     *
     * @return
     */
    public Integer maxValOfSlidingWin() {
        if (size == 0) {
            return null;
        } else {
            return targetArr[maxDeque.peekFirst()];
        }
    }

    /**
     * 返回滑动窗口的最小值，没有则返回null
     * <p>
     * 利用单调双端队列实现
     *
     * @return
     */
    public Integer minValOfSlidingWin() {
        if (size == 0) {
            return null;
        } else {
            return targetArr[minDeque.peekFirst()];
        }
    }

    public int[] computeSlidingWin() {
        int[] sidingWin = new int[0];
        if (size > 0) {
            int tempL = l;
            sidingWin = new int[size];
            int idx = 0;
            while (tempL < r) {
                sidingWin[idx] = targetArr[tempL];
                idx++;
                tempL++;
            }
        }
        return sidingWin;
    }

    public void printSlidingWin() {
        int[] els = computeSlidingWin();
        System.out.print("[");
        for (int el : els) {
            System.out.print(el + ",");
        }
        System.out.print("]");
        System.out.println("max:" + maxValOfSlidingWin());

    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        SlidingWindowUtil util = new SlidingWindowUtil(arr);
        boolean b = util.leftForward();
        util.rightForward();
        util.leftForward();
        util.rightForward();
        util.rightForward();
        util.leftForward();
        util.rightForward();
        util.rightForward();
        util.rightForward();
        util.rightForward();
        util.rightForward();
        util.rightForward();
        util.rightForward();
        util.rightForward();
        //util.rightForward();
        //util.leftForward();
        util.printCurrentPos();
        util.printSlidingWin();
    }

}
