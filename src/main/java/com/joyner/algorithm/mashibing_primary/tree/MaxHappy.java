package com.joyner.algorithm.mashibing_primary.tree;

import com.joyner.algorithm.leetcode_practice.vo.TreeNode;
import com.joyner.algorithm.mashibing_primary.vo.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 派对的最大快乐值
 *  公司的每个员工都符合 Employee 类的描述。整个公司的人员结构可以看作是一棵标准的、 没有环的多叉树。树的头节点是公司唯一的老板。除老板之外的每个员工都有唯一的直接上级。 叶节点是没有任何下属的基层员工(subordinates列表为空)，除基层员工外，每个员工都有一个或多个直接下级。
 *
 *  这个公司现在要办party，你可以决定哪些员工来，哪些员工不来，规则：
 * 1.如果某个员工来了，那么这个员工的所有直接下级都不能来
 * 2.派对的整体快乐值是所有到场员工快乐值的累加
 * 3.你的目标是让派对的整体快乐值尽量大
 * 给定一棵多叉树的头节点boss，请返回派对的最大快乐值。
 * </pre>
 *
 * @author 陆清云 luqy
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class MaxHappy {

    class Info {
        int maxHappy;
    }

    /**
     * 以X为头节点的最大快乐值
     * 1.X不来，把其所有下属的最大快乐值，累加
     * 2.X来，那么其所有的直接下属都不能来，加上X的最大快乐值。
     *
     * @param boss
     * @return
     */
    public int maxHappy(Employee boss) {

        Info info = maxHappyHelp(boss);

        return info.maxHappy;
    }

    private Info maxHappyHelp(Employee boss) {
        if (boss.subordinates == null || boss.subordinates.isEmpty()) {
            Info info = new Info();
            info.maxHappy = 0;
            return info;
        }
        Info result = new Info();

        int xCome = boss.happy;
        int xNotCome = 0;
        List<Employee> subordinates = boss.subordinates;
        for (int i = 0; i < subordinates.size(); i++) {
            Employee employee = subordinates.get(i);
            Info info = maxHappyHelp(employee);
            xNotCome += info.maxHappy;
        }
        int max = Math.max(xCome, xNotCome);
        result.maxHappy = max;
        return result;
    }

    public static void main(String[] args) {
        MaxHappy maxHappy = new MaxHappy();
        Employee boss = new Employee(1);
        List<Employee> subs = new ArrayList<>();
        Employee _2employee = new Employee(2);
        subs.add(_2employee);
        subs.add(new Employee(3));
        subs.add(new Employee(4));
        boss.subordinates = subs;

        subs = new ArrayList<>();
        Employee _1000employee = new Employee(1000);
        subs.add(_1000employee);
        _2employee.subordinates = subs;

        subs = new ArrayList<>();
        Employee _1 = new Employee(1);
        subs.add(_1);
        subs.add(new Employee(2));
        subs.add(new Employee(3));
        _1000employee.subordinates= subs;

        subs = new ArrayList<>();
        subs.add(new Employee(100));
        _1.subordinates = subs;


        int i = maxHappy.maxHappy(boss);
        System.out.println(i);

    }
}
