package com.joyner.algorithm.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.joyner.algorithm.search.vo.Node;

/**
 * breath-first search algorithm
 * @author Joyner-Lu
 * @date 2018-04-18 09:59:41
 *
 */
public class BreathFirstSearch<T> {
	
	public Node<T> breathFirstSearch(Node<T> startNode,Map<Node<T>,List<Node<T>>> datas,IBusinessProcess<T> businessProcess) {
		//it must be validation before do search!
		doValidate(startNode,datas);
		
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		Map<Node<T>,Boolean> checkedNodes = new HashMap<Node<T>, Boolean>();
		
		List<Node<T>> neighbors = datas.get(startNode);
		//push to the queue
		if (neighbors != null && neighbors.size() > 0) {
			pushToQueue(neighbors,queue,startNode);
		}
		
		while (!queue.isEmpty()) {
			Node<T> node = queue.pop();
			//checking whether the node has been checked.
			Boolean isChecked = checkedNodes.get(node);
			if (isChecked == null || !isChecked) {
				//put the node to the checkedNodes
				checkedNodes.put(node, true);
				if (businessProcess.doBusinessProcess(node)) {
					//yes,we find it finally!
					return node;
				} else { 
					//get the neighbors of the node and push to the queue
					neighbors = datas.get(node);
					if (neighbors != null && neighbors.size() > 0) {
						pushToQueue(neighbors,queue,node);
					}
				}
			}
			
		}
		return null;
	}

	private void pushToQueue(List<Node<T>> neighbors, LinkedList<Node<T>> queue,Node<T> currentNode) {
		for (Node<T> neighbor : neighbors) {
			queue.push(neighbor);
			neighbor.setParentNode(currentNode);
		}
	}

	private void doValidate(Node<T> startNode,Map<Node<T>, List<Node<T>>> datas) {
		if (startNode == null) {
			throw new RuntimeException("parameter startNode must be not null,please check it!");
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		BreathFirstSearch<String> s = new BreathFirstSearch<String>();
		//making datas
		Map<Node<String>,List<Node<String>>> datas = new HashMap<Node<String>, List<Node<String>>>();
		Node<String> me = new Node<String>("me");
		Node<String> alice = new Node<String>("alice");
		Node<String> bob = new Node<String>("bob");
		Node<String> claire = new Node<String>("claire");
		Node<String> anuj = new Node<String>("anuj");
		Node<String> peggy = new Node<String>("peggy");
		Node<String> thom = new Node<String>("thom");
		Node<String> jonny = new Node<String>("jonny");
		
		datas.put(me, makeList(alice,bob,claire));
		datas.put(bob, makeList(anuj,peggy));
		datas.put(alice, makeList(peggy));
		datas.put(claire, makeList(thom,jonny));
		datas.put(anuj, null);
		datas.put(peggy, null);
		datas.put(thom, null);
		datas.put(jonny, null);
		
		Node<String> r = s.breathFirstSearch(me, datas, new IBusinessProcess<String>() {
			public boolean doBusinessProcess(Node<String> node) {
				String t = node.getNode();
				String s = t.substring(t.length() -1, t.length());
				System.out.println(s);
				if ("m".equals(s)) {
					return true;
				}
				return false;
			}
		});
		System.out.println(r);
	}
	
	public static List<Node<String>> makeList(Node<String>... nodes) {
		List<Node<String>> r = new ArrayList<Node<String>>();
		for (Node<String> node :nodes ) {
			r.add(node);
		}
		return r;
	}
}
