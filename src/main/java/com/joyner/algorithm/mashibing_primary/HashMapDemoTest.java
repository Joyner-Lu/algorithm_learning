package com.joyner.algorithm.mashibing_primary;

import java.util.HashMap;
import java.util.TreeMap;

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
public class HashMapDemoTest {

    public static class Node {
        public int value;

        public Node(int v) {
            value = v;
        }
    }

    // (K V)表
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        String s1 = "test";
        String s2 = "test";
        System.out.println(s1 == s2);


        HashMap<Integer, String> map1 = new HashMap<>();

        map1.put(1234567, "test");
        Integer a = 1234567;
        Integer b = 1234567;
        System.out.println(a == b);
        System.out.println(map1.containsKey(a));
        System.out.println(map1.containsKey(b));

        TreeMap treeMap1 = new TreeMap();
        treeMap1.put(3, "我是3");
        treeMap1.put(0, "我是3");
        treeMap1.put(7, "我是3");
        treeMap1.put(2, "我是3");
        treeMap1.put(5, "我是3");
        treeMap1.put(9, "我是3");

        System.out.println(treeMap1.firstKey());
        System.out.println(treeMap1.floorKey(5));
        System.out.println(treeMap1.ceilingKey(5));


    }
}
