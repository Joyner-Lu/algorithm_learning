package com.joyner.algorithm.mashibing_primary.graph;

import lombok.Data;

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
@Data
public class Edge {

    /**
     * 边的权重
     */
    private Integer weight;

    /**
     * from点
     */
    private Node from;

    /**
     * to点
     */
    private Node to;

}
