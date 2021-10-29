package com.joyner.algorithm.mashibing_primary.dynamic;

import com.joyner.common.util.collection.ArrUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 给定一个2*3的格子，现在有编号1~5的物品放入格子，没有物品放入的地方，用编号0表示，编号0可以和上下左右的物品交换，要求最后物品的摆放是123450，编码求出给定初始时状态到最终状态需要移动物品的最少步骤，如不能达到最终状态返回-1。感觉没啥想法，帮忙指点下迷津
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
public class CellDemo {

    static Map<String, String> movedMap = new HashMap<>();
    static Map<String, Integer> cached = new HashMap<>();

    public static int min(int[][] cell) {


        //找出零的位置
        int[] zeroPos = findZeroPos(cell);
        if (zeroPos[0] == cell.length - 1 && zeroPos[1] == cell[0].length - 1) {
            //0在最后一个位置
            if (isValid(cell)) {
                return 0;
            }
        }

        //暴力递归
        int row = zeroPos[0];
        int col = zeroPos[1];
        String key = getKey(cell);
        movedMap.put(key, "");
        int r = process(cell, row, col);
        return r == Integer.MAX_VALUE? -1 : r;
    }


    public static String getKey(int[][] cell) {
        String key = "";
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                key += cell[i][j];
            }
        }
        return key;
    }

    /**
     * 找到0的位置
     *
     * @param cell
     *
     * @return
     */
    public static int[] findZeroPos(int[][] cell) {
        int[] r = new int[2];
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if (cell[i][j] == 0) {
                    r[0] = i;
                    r[1] = j;
                    break;
                }
            }
        }
        return r;
    }

    public static boolean isValid(int[][] cell) {
        boolean result = true;
        int val = 1;
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if (i == (cell.length - 1) && j == (cell[0].length - 1)) {
                    if (cell[i][j] != 0) {
                        result = false;
                        break;
                    }
                } else if (cell[i][j] != val) {
                    result = false;
                    break;
                }
                val++;
            }
        }
        return result;

    }

    public static void swap(int[][] cell, int x1, int y1, int x2, int y2) {
        int temp = cell[x1][y1];
        cell[x1][y1] = cell[x2][y2];
        cell[x2][y2] = temp;
    }

    private static int process(int[][] cell, int row, int col) {
        String cachedKey = getKey(cell);
        Integer integer = cached.get(cachedKey);
        if (integer != null) {
            return integer;
        }

        //不在最后一个位置
        int result = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        //向左,列不等于0
        if (col != 0) {
            swap(cell, row, col, row, col - 1);
            String key = getKey(cell);
            boolean valid = isValid(cell);
            if (!valid && movedMap.get(key) == null) {
                movedMap.put(key, "");
                left = process(cell, row, col - 1);
                movedMap.remove(key);
            }

            if (valid) {
                left = 0;
            }

            //还原现场
            swap(cell, row, col - 1, row, col);
        }

        //向右,不在最后一列
        if (col != cell[0].length - 1) {
            swap(cell, row, col, row, col + 1);
            String key = getKey(cell);
            boolean valid = isValid(cell);
            if (!valid && movedMap.get(key) == null) {
                movedMap.put(key, "");
                right = process(cell, row, col + 1);
                movedMap.remove(key);

            }

            if (valid) {
                right = 0;
            }
            //还原现场
            swap(cell, row, col + 1, row, col);
        }

        //向上,不在第一行
        if (row != 0) {
            swap(cell, row, col, row - 1, col);
            String key = getKey(cell);
            boolean valid = isValid(cell);
            if (!valid && movedMap.get(key) == null) {
                movedMap.put(key, "");
                up = process(cell, row - 1, col);
                movedMap.remove(key);

            }

            if (valid) {
                up = 0;
            }
            //还原现场
            swap(cell, row - 1, col, row, col);
        }

        //向下,不在最后一行
        if (row != cell.length - 1) {
            swap(cell, row, col, row + 1, col);
            String key = getKey(cell);
            boolean valid = isValid(cell);
            if (!valid && movedMap.get(key) == null) {
                movedMap.put(key, "");
                down = process(cell, row + 1, col);
                movedMap.remove(key);

            }

            if (valid) {
                down = 0;
            }
            //还原现场
            swap(cell, row + 1, col, row, col);
        }

        if (left != Integer.MAX_VALUE) {
            result = Math.min(left + 1, result);
        }

        if (right != Integer.MAX_VALUE) {
            result = Math.min(right + 1, result);
        }

        if (down != Integer.MAX_VALUE) {
            result = Math.min(down + 1, result);
        }

        if (up != Integer.MAX_VALUE) {
            result = Math.min(up + 1, result);
        }
        //返回最小结果
        cached.put(cachedKey, result);
        return result;


    }


    /**
     * cell[0][0] = 1; cell[0][1] = 5; cell[0][2] = 2;
     * <p>
     * cell[1][0] = 4; cell[1][1] = 3; cell[1][2] = 0;
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] cell = new int[2][3];
        cell[0][0] = 1;
        cell[0][1] = 3;
        cell[0][2] = 2;

        cell[1][0] = 4;
        cell[1][1] = 5;
        cell[1][2] = 0;

        System.out.println(min(cell));

      /*  ArrUtils.printArr(findZeroPos(cell));

        System.out.println(isValid(cell));
        swap(cell, 0, 2, 1, 2);
        System.out.println(isValid(cell));
        ArrUtils.printArr(findZeroPos(cell));*/

    }
}
