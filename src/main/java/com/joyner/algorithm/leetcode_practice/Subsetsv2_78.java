package com.joyner.algorithm.leetcode_practice;

import java.util.ArrayList;
import java.util.List;

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
public class Subsetsv2_78 {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {


        int bitMovCount = nums.length;
        int maxMask = 1 << bitMovCount;//相当于2的bitMovCount次方
        for (int mask = 0; mask < maxMask; mask++) {
            t = new ArrayList<>();
            for (int idx = 0; idx < bitMovCount; idx++) {
                if ((mask & (1 << idx)) != 0) {
                    //使用1左移来试探位置。
                    //[5,2,9]
                    // 0(idx2), 0(idx1), 1(idx0)  则对应： [5]
                    // 1(idx2), 1(idx1), 0(idx0) 则对应：[2, 9]
                    t.add(nums[idx]);
                }
            }
            ans.add(t);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {5, 2, 9};

        Subsetsv2_78 subsets_78 = new Subsetsv2_78();
        subsets_78.subsets(nums);
        System.out.println(subsets_78.ans);
    }
}
