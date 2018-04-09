package com.joyner.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * binary search algorithm
 * @author Joyner-Lu
 * @date 2018-04-02 17:01:49
 *
 * @param <T>
 */
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
			searchTimes ++;
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
			
		}
		
		this.binarySearchResult.setSearchTimes(searchTimes);
		
	}
	
	private void doBinarySearchByDC(List<T> dataList, T target) {
		if (dataList.size() == 1) {
			if (dataList.get(0).compareTo(target) == 0) {
				System.out.println("find id@!");
			}
			return;
		}
		T first = dataList.get(0);
		dataList.remove(0);
		
		if (target.compareTo(first) == 0) {
			System.out.println("find id@!");
			return;
		} else {
			doBinarySearchByDC(dataList,target);
		}
		
	}
	
	public static void main(String[] args) {
		List<Integer> data = new ArrayList<Integer>();
		data.add(1);
		data.add(2);
		data.add(50);
		BinarySearch<Integer> s = new BinarySearch<Integer>(data,1);
		System.out.println(s.getResult());
	}


}
