package com.joyner.algorithm.search.bfs.vo;

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
	
	public T getNode() {
		return node;
	}
	public void setNode(T node) {
		this.node = node;
	}
	@Override
	public String toString() {
		return "Node [node=" + node + "]";
	}
	
	
}
