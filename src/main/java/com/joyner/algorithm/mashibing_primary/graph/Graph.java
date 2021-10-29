package com.joyner.algorithm.mashibing_primary.graph;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * 图由点集和边集组成
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
public class Graph {
    /**
     * 点集
     */
    private Map<Integer, Node> nodeMap = new HashMap<>();

    /**
     * 边集
     */
    private Set<Edge> edgeSet = new HashSet<>();
}
