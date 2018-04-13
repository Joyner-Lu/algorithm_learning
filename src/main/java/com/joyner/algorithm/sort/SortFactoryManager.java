package com.joyner.algorithm.sort;

public class SortFactoryManager {
	
	/**
	 * get SelectionSort instance
	 * @return
	 */
	public static <T extends Comparable<T>> SelectionSort<T> getSelectionSortInstance() {
		return new SelectionSort<T>();
	}
	
	/**
	 * get QuickSort instance
	 * @return
	 */
	public static <T extends Comparable<T>> QuickSort<T> getQuickSortInstance() {
		return new QuickSort<T>();
	}

}
