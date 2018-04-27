package com.joyner.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

/**
 * quick sort algorithm
 * 
 * @author Joyner-Lu
 * @date 2018-04-13 15:41:58
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> implements ISort<T> {

	public List<T> doSort(List<T> dataList) {
		doValidate(dataList);
		// here we go!
		List<T> r = doQuikSort(dataList, SortType.ASC);
		return r;
	}

	public List<T> doSort(List<T> dataList, SortType sortType) {
		doValidate(dataList);
		// here we go!
		List<T> r = doQuikSort(dataList, sortType);
		return r;
	}

	private List<T> doQuikSort(List<T> dataList, SortType sortType) {
		List<T> r = null;
		switch (sortType) {
		case ASC:
			r = doQuikSortByAsc(dataList);
			break;
		case DESC:
			r = doQuikSortByDesc(dataList);
			break;
		default:
			break;
		}
		return r;
	}

	private List<T> doQuikSortByDesc(List<T> dataList) {
		if (dataList.size() < 2) {
			return dataList;
		}
		int randomIndex = RandomUtils.nextInt(0, dataList.size());
		// the pivot value
		T pivot = dataList.get(randomIndex);
		List<T> less = new ArrayList<T>();
		List<T> greater = new ArrayList<T>();
		for (int i = 1; i < dataList.size(); i++) {
			T data = dataList.get(i);
			if (data.compareTo(pivot) == 1) {
				greater.add(data);
			} else {
				less.add(data);
			}
		}
		List<T> r = new ArrayList<T>();
		r.addAll(doQuikSortByDesc(greater));
		r.add(pivot);
		r.addAll(doQuikSortByDesc(less));
		return r;
	}

	private List<T> doQuikSortByAsc(List<T> dataList) {
		if (dataList.size() < 2) {
			return dataList;
		}
		int randomIndex = RandomUtils.nextInt(0, dataList.size());
		// the pivot value
		T pivot = dataList.get(randomIndex);
		List<T> less = new ArrayList<T>();
		List<T> greater = new ArrayList<T>();
		for (int i = 1; i < dataList.size(); i++) {
			T data = dataList.get(i);
			if (data.compareTo(pivot) == 1) {
				greater.add(data);
			} else {
				less.add(data);
			}
		}
		List<T> r = new ArrayList<T>();
		r.addAll(doQuikSortByAsc(less));
		r.add(pivot);
		r.addAll(doQuikSortByAsc(greater));
		return r;
	}

}
