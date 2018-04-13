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
public class SelectionSort<T extends Comparable<T>> extends AbstractSort<T> implements ISort<T> {
	
	private List<T> result = new ArrayList<T>();
	
	public List<T> doSort(List<T> dataList) {
		doValidate(dataList);
		doSelectionSortByAsc(dataList);
		return result;
	}

	public List<T> doSort(List<T> dataList, SortType sortType) {
		doValidate(dataList);
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
		return result;
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
	
	

}
