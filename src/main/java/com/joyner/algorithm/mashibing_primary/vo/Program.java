package com.joyner.algorithm.mashibing_primary.vo;

import java.util.Comparator;

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
public class Program implements Comparable {
    public int start;
    public int end;

    public Program(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}