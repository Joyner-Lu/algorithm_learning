package com.joyner.algorithm.search;

import com.joyner.algorithm.search.vo.Node;

public class DijkstraSearchVO<T> {
	
	private Node<T> node;
	private Integer cost;
	
	public Node<T> getNode() {
		return node;
	}
	public void setNode(Node<T> node) {
		this.node = node;
	}
	@Override
	public String toString() {
		return "DijkstraSearchVO [node=" + node + ", cost=" + cost + "]";
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	

}
