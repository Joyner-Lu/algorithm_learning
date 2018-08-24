package com.joyner.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionDemo {

	/**
	 * get the dataList's sum by use the D&C method
	 * D&C:divide and conquer
	 * @param dataList
	 * @return
	 */
	public static int sum(List<Integer> dataList) {
		if (dataList == null) {
			throw new RuntimeException("the parameter dataList must be not null,please check it!");
		}
		
		//the base condition
		if (dataList.size() == 0) {
			return 0;
		}
		int data = dataList.get(0);
		dataList.remove(0);
		
		return data + sum(dataList);
		
	}
	
	public static int count(List<Integer> dataList) {
		if (dataList == null) {
			throw new RuntimeException("the parameter dataList must be not null,please check it!");
		}
		
		if (dataList.isEmpty()) {
			return 0;
		}
		dataList.remove(0);
		
		return 1 + count(dataList);
		
	}
	
	public static int findMax(List<Integer> dataList) {
		if (dataList == null) {
			throw new RuntimeException("the parameter dataList must be not null,please check it!");
		}
		
		//the base condition
		if (dataList.size() == 2) {
			int first = dataList.get(0);
			int second = dataList.get(1);
			return first > second ? first : second;
		}
		
		int fisrt = dataList.get(0);
		dataList.remove(0);
		int subMax = findMax(dataList);
		
		return fisrt > subMax ? fisrt : subMax;
		
	}
	
	public static void main(String[] args) {
		List<Integer> s = new ArrayList<Integer>();
		s.add(21);
		s.add(8);
		s.add(7);
		//int sum = sum(s);
		//System.out.println(sum);
		
		System.out.println(findMax(s));
	}
	
}
