package com.joyner.algorithm.leetcode_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *
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
public class Permutations_46 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * 递归实现
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        if( nums.length == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }

        if (nums.length == 1) {
            ans.add(Arrays.asList(1));
            return ans;
        }

        //1, 2, 3
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            //最外层选择第一层的元素
            List<Integer> curList = new ArrayList<>();
            curList.add(n);
            //每一层都使用递归
            doPermute(curList, newArr(i, nums), nums.length);

        }
        return ans;

    }

    /**
     *
     * @param curList
     * @param newNums
     * @param ansLen 层的最大长度
     */
    private void doPermute(List<Integer> curList, int[] newNums, int ansLen) {
        for (int i = 0; i < newNums.length; i++) {
            int n = newNums[i];
            List<Integer> newCurr = new ArrayList<>();
            newCurr.addAll(curList);
            newCurr.add(n);
            if (newCurr.size() == ansLen) {
                ans.add(newCurr);
                return;
            } else {
                doPermute(newCurr, newArr(i, newNums), ansLen);
            }
        }
    }

    public int[] newArr(int excludeIdx, int[] nums) {
        int [] newArr = new int[nums.length - 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != excludeIdx) {
                newArr[j] =  nums[i];
                j++;
            }
        }
        return newArr;
    }


    public static void main(String[] args) {
        int[] nums = {1};
        Permutations_46 permutations_46 = new Permutations_46();
        permutations_46.permute(nums);
        System.out.println();
    }
}
