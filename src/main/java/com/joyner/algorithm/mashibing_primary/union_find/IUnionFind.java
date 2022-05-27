package com.joyner.algorithm.mashibing_primary.union_find;

/**
 * <pre>
 *
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
public interface IUnionFind<V> {
    /**
     * 是否同一个集合
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isSameSet(V a, V b);

    /**
     * 把a所在的集合和b所在的集合进行合并
     *
     * @param a
     * @param b
     */
    public void union(V a, V b);

    /**
     * 新增一个元素
     * @param value
     */
    public void add(V value);
}
