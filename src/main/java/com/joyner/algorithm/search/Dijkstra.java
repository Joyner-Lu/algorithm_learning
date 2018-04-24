package com.joyner.algorithm.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.joyner.algorithm.search.vo.Node;

/**
 * dijkstra algorithm
 * @author Joyner-Lu
 * @date 2018-04-24 10:17:10
 *
 */
public class Dijkstra<T> {
	
	public DijkstraSearchVO<T> doDijkstra(Node<T> startNode,Node<T> target, Map<Node<T>,Map<Node<T>,Integer>> datas) {
		dovalidate(startNode,target,datas);
		
		Map<Node<T>,Integer> costs = new HashMap<Node<T>, Integer>();
		Map<Node<T>,Boolean> checkedNodes = new HashMap<Node<T>, Boolean>();
		
		//init costs
		initCosts(startNode,target,datas,costs);
		
		//here we go!
		Node<T> lowestCostNode =  findLowestCostNode(costs,checkedNodes);
		while(lowestCostNode != null) {
			Integer cost = costs.get(lowestCostNode);
			Map<Node<T>, Integer> neighbors = datas.get(lowestCostNode);
			Set<Node<T>> keys = neighbors.keySet();
			for (Node<T> key : keys) {
				int newCost = cost + neighbors.get(key);
				if (costs.get(key) > newCost) {
					//do update
					costs.put(key, newCost);
					key.setParentNode(lowestCostNode);
				}
			}
			checkedNodes.put(lowestCostNode, true);
			lowestCostNode =  findLowestCostNode(costs,checkedNodes);
		}
		DijkstraSearchVO<T> dijkstraSearchVO = new DijkstraSearchVO<T>();
		dijkstraSearchVO.setNode(target);
		dijkstraSearchVO.setCost(costs.get(target));
		
		return dijkstraSearchVO;
	}

	private void initCosts(Node<T> startNode,Node<T> target, Map<Node<T>,Map<Node<T>,Integer>> datas,Map<Node<T>,Integer> costs) {
		Set<Node<T>> keys = datas.keySet();
		for (Node<T> key : keys) {
			if (key.equals(startNode)) {
				//we can know the cost from neighbors of startNode to startNode
				Map<Node<T>, Integer> neighbors = datas.get(key);
				for (Node<T> k : neighbors.keySet()) {
					k.setParentNode(startNode);
					costs.put(k,neighbors.get(k));
				}
			} else {
				Integer cost = costs.get(key);
				if (cost == null) {
					key.setParentNode(null);
					costs.put(key, Integer.MAX_VALUE);
				}
			}
		}
	}

	private Node<T> findLowestCostNode(Map<Node<T>, Integer> costs,Map<Node<T>,Boolean> checkedNodes) {
		int lowestCost = Integer.MAX_VALUE;
		Node<T> result = null;
		for (Node<T> node : costs.keySet()) {
			Integer cost = costs.get(node);
			if (cost < lowestCost && checkedNodes.get(node) == null) {
				//update
				lowestCost = cost;
				result = node;
			}
		}
		return result;
	}

	private void dovalidate(Node<T> startNode, Node<T> target, Map<Node<T>, Map<Node<T>, Integer>> datas) {
		if (datas == null || datas.size() == 0) {
			throw new RuntimeException("parameter datas must be not null or empty,please check it!");
		}
		
		if (!datas.containsKey(startNode)) {
			throw new RuntimeException("parameter startNode is illegal，it should be contained in datas!");
		}
		
		if (!datas.containsKey(target)) {
			throw new RuntimeException("parameter target is illegal，it should be contained in datas!");
		}
	}

	public static void main(String[] args) {
		Node<String> startNode = new Node<String>("startNode");
		Node<String> endNode = new Node<String>("endNode");
		Map<Node<String>,Map<Node<String>,Integer>> datas = buidDatas(startNode,endNode);
		Dijkstra<String> dj = new Dijkstra<String>();
		DijkstraSearchVO<String>  r = dj.doDijkstra(startNode, endNode, datas);

		System.out.println(r);
	}

	private static Map<Node<String>, Map<Node<String>, Integer>> buidDatas(Node<String> startNode,Node<String> endNode) {
		
		Node<String> a = new Node<String>("a");
		Node<String> b = new Node<String>("b");
		
		Map<Node<String>,Map<Node<String>,Integer>> datas = new HashMap<Node<String>,Map<Node<String>,Integer>>();
		
		Map<Node<String>,Integer> startMap = new HashMap<Node<String>, Integer>();
		startMap.put(a, 6);
		startMap.put(b,2);
		datas.put(startNode, startMap);
		
		//a map
		Map<Node<String>,Integer> aMap = new HashMap<Node<String>, Integer>();
		aMap.put(endNode, 1);
		datas.put(a, aMap);
		
		//b map 
		Map<Node<String>,Integer> bMap = new HashMap<Node<String>, Integer>();
		bMap.put(a, 3);
		bMap.put(endNode, 5);
		datas.put(b, bMap);
		 
		Map<Node<String>,Integer> endMap = new HashMap<Node<String>, Integer>();
		datas.put(endNode, endMap);
		
		return datas;
	}
	
}
