package com.joyner.algorithm.leetcode_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
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
public class MajorityElement_169 {

    Map<Integer, Integer> elementCount = new HashMap<>();

    public int majorityElement(int[] nums) {
        int result = 0;
        int halfLen = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            Integer element = elementCount.get(nums[i]);
            int count = 1;
            if (element != null) {
                count += element;
            }
            elementCount.put(nums[i], count);
        }

        Set<Map.Entry<Integer, Integer>> entrySet = elementCount.entrySet();
        for (Map.Entry<Integer, Integer> entry: entrySet) {
            if (entry.getValue() > halfLen) {
                result = entry.getKey();
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        MajorityElement_169 majorityElement_169 = new MajorityElement_169();
        int result = majorityElement_169.majorityElement(arr);
        System.out.println(result);
    }
}
