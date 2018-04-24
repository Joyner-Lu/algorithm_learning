package com.joyner.algorithm.search;

import com.joyner.algorithm.search.vo.Node;

public interface IBusinessProcess<T> {
	
	public boolean doBusinessProcess(Node<T> node);

}
