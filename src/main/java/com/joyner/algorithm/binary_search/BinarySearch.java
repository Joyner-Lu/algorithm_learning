package com.joyner.algorithm.binary_search;

import java.util.Arrays;
import java.util.List;

public class BinarySearch<T extends Comparable<T>> {
	
	private BinarySearchResult<T> binarySearchResult = new BinarySearchResult<T>();
	
	public BinarySearch(List<T> dataList, T target) {
		if (dataList == null || dataList.size() == 0) {
			 return;
		}
		//here we go!!!
		doBinarySearch(dataList,target);
		
	};
	
	public BinarySearchResult<T> getResult() {
		return binarySearchResult;
	}
	
	private void doBinarySearch(List<T> dataList, T target) {
		int low = 0;
		int hight = dataList.size() - 1;
		int mid = (hight + low) / 2;
		int searchTimes = 0;
		
		while (hight >= low) {
			T guess = dataList.get(mid);
			if (guess.compareTo(target) == 0) {
				this.binarySearchResult.setLocation(mid + 1);
				break;
			} else if (guess.compareTo(target) == 1) {
				//guess > target
				//change the hight index location
				hight = mid - 1;
			} else if (guess.compareTo(target) == -1) {
				//guess < target
				//change the low index location
				low = mid + 1;
			}
			mid = (hight + low) / 2;
			searchTimes ++;
		}
		
		this.binarySearchResult.setSearchTimes(searchTimes);
		
	}
	
	public static void main(String[] args) {
		BinarySearch<Integer> s = new BinarySearch<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10),102);
		System.out.println(s.getResult());
	}


}
