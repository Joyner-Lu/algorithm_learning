package com.joyner.algorithm.sort;

import java.util.List;

public abstract class AbstractSort<T extends Comparable<T>> implements ISort<T> {
	
	//before sorts the arr dovalidation first
	public void doValidate(List<T> dataList) {
		if (dataList == null || dataList.size() == 0) {
			throw new RuntimeException("the parameter dataList must be not null,please check it!");
		}
	}


}
