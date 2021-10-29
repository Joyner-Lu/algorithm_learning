package com.joyner.algorithm.mashibing_primary.graph;

import lombok.Data;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 图中的点
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
public class Node {


    /**
     * 点的值
     */
    private Integer value;

    /**
     * 点的入度
     */
    private Integer in = 0;

    /**
     * 点的出度
     */
    private Integer out = 0;

    /**
     * 直接邻居
     */
    private List<Node> nextList = new ArrayList<>();

    /**
     * 直接邻居对应的边
     */
    private List<Edge> edgeList = new ArrayList<>();

}
