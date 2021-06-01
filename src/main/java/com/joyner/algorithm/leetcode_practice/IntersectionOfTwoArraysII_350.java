package com.joyner.algorithm.leetcode_practice;

import java.util.*;

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
public class IntersectionOfTwoArraysII_350 {

    List<Integer> list = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] largeLenArr = nums1.length > nums2.length ?  nums1 : nums2;
        int[] lessLenArr = nums1.length > nums2.length ?  nums2 : nums1;

        for (int i = 0; i < largeLenArr.length; i++) {
            list.add(largeLenArr[i]);
        }

        for (int i = 0; i < lessLenArr.length; i++) {
            if (list.contains(lessLenArr[i])) {
                Object val = lessLenArr[i];
                list.remove(val);//移除掉，否则会影响下一个判断
                result.add(lessLenArr[i]);
            }
        }

        Iterator<Integer> iterator = result.iterator();
        int[] resultArr = new int[result.size()];
        int i = 0;
        while (iterator.hasNext()) {
            int val = iterator.next();
            resultArr[i++] = val;
        }

        return resultArr;
    }


    public static void main(String[] args) {
        int[] arr1 = {4,9,5,1};
        int[] arr2 = {1,1};
        IntersectionOfTwoArraysII_350 intersectionOfTwoArraysII_350 = new IntersectionOfTwoArraysII_350();
        int[] result = intersectionOfTwoArraysII_350.intersect(arr1, arr2);
        System.out.println();
    }
}
