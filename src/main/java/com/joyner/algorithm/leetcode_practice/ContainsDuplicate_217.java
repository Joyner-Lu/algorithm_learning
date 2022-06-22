package com.joyner.algorithm.leetcode_practice;

import java.util.HashSet;
import java.util.Set;

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
public class ContainsDuplicate_217 {

    Set<Integer> set = new HashSet<>();

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (set.remove(nums[i])) {
                //能删除成功，证明之前有过这个元素
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        ContainsDuplicate_217 containsDuplicate_217 = new ContainsDuplicate_217();
        boolean b = containsDuplicate_217.containsDuplicate(arr);
        System.out.println(b);
    }

}
