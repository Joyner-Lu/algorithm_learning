package com.joyner.algorithm.mashibing_primary.greedy;

import com.joyner.algorithm.mashibing_primary.vo.Program;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <pre>
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间
 * 你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。
 * 返回最多的宣讲场次
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
public class BestArrange {

    /**
     * 暴力解，穷举
     *
     */
    public static int bestArrange1(Program[] programs) {
        if (programs == null || programs.length == 0) {
            return 0;
        }

        boolean[] use = new boolean[programs.length];
        int maxProgram = 0;
        int idx = 0;
        int endTime = 0;
        int result = process(use, programs,maxProgram, idx, endTime);

        return result;
    }

    private static int process(boolean[] use, Program[] programs, int maxProgram, int idx, int endTime) {
        if (idx == programs.length) {
            //结束条件
            return maxProgram;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < programs.length; i++) {
            int newIdx = idx + 1;
            if (!use[i]) {
                int newEndTime = endTime;
                int newMaxProgram = maxProgram;
                if (programs[i].start >= endTime) {
                    newMaxProgram = maxProgram + 1;
                    //更新end time
                    newEndTime = programs[i].end;
                }
                use[i] = true;
                int max = process(use, programs, newMaxProgram, newIdx, newEndTime);
                //取最大值
                result = Math.max(result, max);
                use[i] = false;
            }
        }
        return result;
    }

    /**
     * 按时间结束最早处理
     * @param programs
     * @return
     */
    public static int bestArrange2(Program[] programs) {
        if (programs == null || programs.length == 0) {
            return 0;
        }
        PriorityQueue<Program> queue = new PriorityQueue<>(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.end - o2.end;
            }
        });
        for (int i = 0; i < programs.length; i++) {
            queue.offer(programs[i]);
        }

        int result = 1;
        int endTime = queue.poll().end;
        while (!queue.isEmpty()) {
            Program poll = queue.poll();
            if (poll.start >= endTime) {
                result++;
                endTime = poll.end;
            }
        }

        return result;


    }

    public static void main(String[] args) {
        Program[] programs = new Program[3];
        programs[0] = new Program(0,9);
        programs[1] = new Program(0, 3);
        programs[2] = new Program(4, 5);

        System.out.println(bestArrange1(programs));
        System.out.println(bestArrange2(programs));
    }
}
