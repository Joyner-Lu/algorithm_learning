package com.joyner.algorithm.leetcode_practice;

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
public class SuperWashingMachines_517 {

    public int findMinMoves(int[] machines) {
        boolean isCanMove = isCanMove(machines);
        if (!isCanMove) {
            return -1;
        }
        int r = process(machines, 0, machines.length -1);
        return r;
    }

    /**
     *
     *
     * @param machines
     * @param l
     * @param r
     * @return
     */
    private int process(int[] machines, int l, int r) {
        return 0;
    }


    public int findMaxIndex(int[] machines) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < machines.length; i++) {
            if (machines[i] > max) {
                max = machines[i];
                index = i;
            }

        }
        return index;
    }

    public int findMinIndex(int[] machines) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < machines.length; i++) {
            if (machines[i] < min) {
                min = machines[i];
                index = i;
            }
        }
        return index;
    }

    private boolean isCanMove(int[] machines) {
        int r = 0;
        for (int i = 0; i < machines.length; i++) {
            r += machines[i];
        }
        //求余数
        int reg = r % machines.length;
        return reg == 0;
    }

    public static void main(String[] args) {
        int[] machines = {1, 0, 5};
        SuperWashingMachines_517 superWashingMachines_517 = new SuperWashingMachines_517();
        int minMoves = superWashingMachines_517.findMinMoves(machines);
        System.out.println(minMoves);
    }

}
