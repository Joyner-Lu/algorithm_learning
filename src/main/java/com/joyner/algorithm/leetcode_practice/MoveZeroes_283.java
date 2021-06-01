package com.joyner.algorithm.leetcode_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

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
public class MoveZeroes_283 {


    public void moveZeroesv1(int[] nums) {
        int ignoreLen = 0;
        for (int i = 0; i < nums.length - ignoreLen; i++) {
            //移动完毕以为，判断前面的一位是否也是0，顺便移动
            //因为移动过一轮，所以直接使用i
            if (nums[i] == 0) {
                exchangePos(i, nums, ignoreLen++);
                if (nums[i] == 0) {
                    i--;//还是从当前位置开始
                }
            }

        }

    }

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    private void exchangePos(int i, int[] nums, int ignoreLen) {
        while (i < nums.length -1 - ignoreLen) {
            nums[i] = nums[i+1];
            nums[i+1] = 0;
            i++;
        }
    }

    public static void main(String[] args) {
       /* int[] arr = {0,0,0,-1064494214,-1007390328,0};
        MoveZeroes_283 moveZeroes_283 = new MoveZeroes_283();
        moveZeroes_283.moveZeroes(arr);
        System.out.println();*/
        ConcurrentHashMap map = new ConcurrentHashMap();
        int i =0;
        while (i < 10000) {
            map.put(i, "1");
            i++;
        }
    }

}
