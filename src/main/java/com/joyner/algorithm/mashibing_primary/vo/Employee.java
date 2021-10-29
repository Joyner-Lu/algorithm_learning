package com.joyner.algorithm.mashibing_primary.vo;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class Employee {

    public Employee(int happy) {
        this.happy = happy;
    }

    /**
     * 这名员工可以带来的快乐值
     */
    public int happy = 0;


    /**
     * 这名员工有哪些直接下级
     */
    public List<Employee> subordinates;

}
