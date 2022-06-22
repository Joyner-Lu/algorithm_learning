package com.joyner.algorithm.leetcode_practice;

import java.util.HashMap;
import java.util.Map;

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
public class TwoSum_371 {

    Map<Integer, Integer> hashMap = new HashMap<>();

    /**
     * 还有一种是暴力搜索，遍历每一个元素
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (hashMap.containsKey(target - x)) {
                result[0] = hashMap.get(target - x);
                result[1] = i;
            }
            hashMap.put(x, i);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum_371 twoSum_371 = new TwoSum_371();
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        for (int x :
                twoSum_371.twoSum(arr, target)) {
            System.out.println(x);
        }
    }
}
