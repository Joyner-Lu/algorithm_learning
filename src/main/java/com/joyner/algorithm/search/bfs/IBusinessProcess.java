package com.joyner.algorithm.search.bfs;

import com.joyner.algorithm.search.bfs.vo.Node;

public interface IBusinessProcess<T> {
	
	public boolean doBusinessProcess(Node<T> node);

}
