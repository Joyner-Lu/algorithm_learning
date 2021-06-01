package com.joyner.algorithm.leetcode_practice;

import java.util.ArrayList;
import java.util.Arrays;
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
public class Subsets_78 {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        //例如长度位3，这里就是bit的位数
        int n = nums.length;

        //1 << n 这里是1左移n位，例如1 << n 也就是1左移3位，相当于2的3次方
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {//每个mask移动的bit的位数，也就是n
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {5, 2, 9};

        Subsets_78 subsets_78 = new Subsets_78();
        subsets_78.subsets(nums);
        System.out.println(subsets_78.ans);
    }
}
