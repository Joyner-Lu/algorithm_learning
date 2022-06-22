package com.joyner.algorithm.leetcode_practice;

import com.joyner.common.util.collection.ArrUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * 使用广度（宽度）优先遍历
 * </pre>
 *
 * @author 陆清云 luqingyun@joyner.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class Permutations_dfsV3_46 {


    /**
     * 深度优先遍历进行处理
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        //当前固定的位置
        int fixPosition = 0;
        permutationHelpV2(nums, ans, fixPosition);
        return ans;

    }


    private static void permutationHelpV2(int[] nums, List<List<Integer>> result,int fixPosition) {
        if (fixPosition == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        for (int i = fixPosition; i < nums.length; i++) {
            swap(nums, i, fixPosition);
            permutationHelpV2(nums, result, fixPosition + 1);
            //恢复现场
            swap(nums, i, fixPosition);
        }
    }

    /**
     * 把数组i和j位置互换
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations_dfsV3_46 permutations_bfs_46 = new Permutations_dfsV3_46();
        permutations_bfs_46.permute(nums);
    }
}
