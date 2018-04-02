package com.joyner.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * selection sort algorithm
 * @author Joyner-Lu
 * @date 2018-04-02 17:02:28
 *
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> {
	
	static enum SortType {
		ASC,DESC;
	};
	
	private List<T> result = new ArrayList<T>();
	
	//use this constructor the default SortType is SortType.ASC
	public SelectionSort(List<T> dataList) {
		boolean r = doValidate(dataList);
		if (r) {
			doSelectionSort(dataList,SortType.ASC);
		}
	};
	
	public SelectionSort(List<T> dataList,SortType sortType) {
		boolean r = doValidate(dataList);
		if (r) {
			doSelectionSort(dataList,sortType);
		}
		
	};

	//before sorts the arr dovalidation first
	private boolean doValidate(List<T> dataList) {
		if (dataList == null || dataList.size() == 0) {
			return false;
		}
		return true;
	}

	private void doSelectionSort(List<T> dataList, SortType sortType) {
		switch (sortType) {
		case ASC:
			doSelectionSortByAsc(dataList);
			break;
		case DESC:
			doSelectionSortByDesc(dataList);
			break;
		default:
			break;
		}
	}
	
	private void doSelectionSortByDesc(List<T> dataList) {
		while (dataList.size() > 0) {
			DataVO dataVO = findMaximum(dataList); 
			dataList.remove(dataVO.getIndex());
			result.add(dataVO.getData());
		}
		
	}

	private DataVO findMaximum(List<T> dataList) {
		int index = 0;
		T maximumData = dataList.get(index);
		for (int i = 1; i < dataList.size(); i++) {
			if (dataList.get(i).compareTo(maximumData) == 1) {
				maximumData = dataList.get(i);
				index = i;
			}
		}
		return new DataVO(maximumData,index);
	}
	
	private class DataVO {
		
		public DataVO(T data, int index) {
			super();
			this.data = data;
			this.index = index;
		}
		private T data;
		private int index;
		
		public T getData() {
			return data;
		}
		
		public int getIndex() {
			return index;
		}
		
		
	}

	private void doSelectionSortByAsc(List<T> dataList) {
		while (dataList.size() > 0) {
			DataVO dataVO = findMinimum(dataList);
			dataList.remove(dataVO.getIndex());
			result.add(dataVO.getData());
		}
			
		
	}

	private DataVO findMinimum(List<T> dataList) {
		int index = 0;
		T minimumData = dataList.get(index); 
		for (int i = 1; i < dataList.size(); i++) {
			if (dataList.get(i).compareTo(minimumData) == -1) {
				minimumData = dataList.get(i);
				index = i;
			}
		}
		return new DataVO(minimumData,index);
	}
	
	public List<T> getResult() {
		return this.result;
	}

	public static void main(String[] args) {
		List<Integer> tt = new ArrayList<Integer>();
		tt.add(31);
		tt.add(33);
		tt.add(2);
		tt.add(3);
		tt.add(9);
		tt.add(10);
		SelectionSort<Integer> s = new SelectionSort<Integer>(tt,SortType.ASC);
		System.out.println(s.getResult());
	}

}
