package com.joyner.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionDemo {

	/**
	 * get the dataList's sum by use the D&C method
	 * @param dataList
	 * @return
	 */
	public static int sum(List<Integer> dataList) {
		if (dataList == null) {
			throw new RuntimeException("the dataList must be not null,please check it!");
		}
		
		//the base condition
		if (dataList.size() == 0) {
			return 0;
		}
		int data = dataList.get(0);
		dataList.remove(0);
		
		return data + sum(dataList);
		
	}
	
	public static void main(String[] args) {
		List<Integer> s = new ArrayList<Integer>();
		s.add(2);
		s.add(8);
		s.add(5);
		int sum = sum(s);
		System.out.println(sum);
	}
	
}
