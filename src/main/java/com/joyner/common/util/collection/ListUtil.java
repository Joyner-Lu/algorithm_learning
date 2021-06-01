package com.joyner.common.util.collection;

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
public class ListUtil {


    public static List<Integer> copy(List<Integer> list) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ans.add(list.get(i));
        }
        return ans;
    }

    public  static void print(List<List<Integer>> target) {
        System.out.println("[");
        for (int i = 0; i < target.size(); i++) {
            List secondList = target.get(i); 
            int secondLen = secondList.size();
            System.out.print("[");
            for (int j = 0; j < secondLen; j++) {
                Object val = secondList.get(j);
                System.out.print(val + ",");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public  static void printV2(List<Integer> target) {
        System.out.print("[");
        for (int i = 0; i < target.size(); i++) {
            Object val = target.get(i);
            System.out.print(val + ",");
        }
        System.out.println("]");
    }
}
