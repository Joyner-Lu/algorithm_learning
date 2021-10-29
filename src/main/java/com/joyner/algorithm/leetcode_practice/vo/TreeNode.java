package com.joyner.algorithm.leetcode_practice.vo;

import org.apache.commons.lang3.StringUtils;

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

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(String x) {
        String trim = x.trim();
        this.val = Integer.valueOf(trim);
    }

    public static TreeNode build(String x) {
        if (StringUtils.isEmpty(x.trim())) {
            return null;
        }

        if ("null".equals(x.trim())) {
            return null;
        }

        return new TreeNode(x);
    }

    @Override
    public String toString() {
        return val + "";
    }
}