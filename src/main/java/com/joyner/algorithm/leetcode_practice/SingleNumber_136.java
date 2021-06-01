package com.joyner.algorithm.leetcode_practice;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
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
public class SingleNumber_136 {

    Map<Integer, Integer> map = new HashMap();

    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            Integer num = map.get(nums[i]);
            if (num == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], num + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumberv2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        SingleNumber_136 singleNumber_136 = new SingleNumber_136();
        int[] arr = {4,1,2,1,2};
        int result = singleNumber_136.singleNumber(arr);
        System.out.println(result);
    }
}
