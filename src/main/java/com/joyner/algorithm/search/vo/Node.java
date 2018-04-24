package com.joyner.algorithm.search.vo;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Joyner-Lu
 * @date 2018-04-18 10:12:13
 *
 * @param <T>
 */
public class Node<T> {
	
	public Node(T t) {
		this.setNode(t);
	}

	private T node;
	
	private Node<T> parentNode;
	
	public T getNode() {
		return node;
	}
	public void setNode(T node) {
		this.node = node;
	}
	@Override
	public String toString() {
		String str = "";
		Node<T> parentNode = getParentNode();
		str = "Node [node=" + node + ",path:" + node + "-->";
		while (parentNode != null) {
			str += parentNode.getNode() + "-->";
			parentNode = parentNode.getParentNode();
		}
		str = StringUtils.removeEnd(str, "-->");
		str += "]";
		return str;
		
	}
	public Node<T> getParentNode() {
		return parentNode;
	}
	public void setParentNode(Node<T> parentNode) {
		this.parentNode = parentNode;
	}
	
	
}
