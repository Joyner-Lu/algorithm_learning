package com.joyner.algorithm.sort;

import java.util.List;

public interface ISort<T extends Comparable<T>> {
	
	/**
	 * do sort, order by asc
	 * @param dataList
	 * @return
	 */
	public List<T> doSort(List<T> dataList);

	/**
	 * do sort, order by asc
	 * @param dataArr
	 * @return
	 */
	public T[] doSort(T[] dataArr);
	
	/**
	 * do sort, the sequence of the result is according the parameter sortType
	 * @param dataList
	 * @param sortType
	 * @return
	 */
	public List<T> doSort(List<T> dataList, SortType sortType);

}
