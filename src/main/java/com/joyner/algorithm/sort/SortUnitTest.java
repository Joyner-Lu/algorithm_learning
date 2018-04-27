package com.joyner.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SortUnitTest {
	
	@Test
	public void testSelectionSort() {
		List<Integer> dataList = new ArrayList<Integer>();
		dataList.add(31);
		dataList.add(33);
		dataList.add(2);
		dataList.add(3); 
		dataList.add(9);
		dataList.add(10);
		SelectionSort<Integer> selectionSort = SortFactoryManager.getSelectionSortInstance();
		List<Integer> r = selectionSort.doSort(dataList,SortType.DESC);
		System.out.println(r);
	}
	
	@Test
	public void testQuickSort() { 
		List<Integer> dataList = new ArrayList<Integer>();
		dataList.add(31);
		dataList.add(33);
		dataList.add(2);
		dataList.add(3);
		dataList.add(9);
		dataList.add(10);
		QuickSort<Integer> quickSort = SortFactoryManager.getQuickSortInstance();
		List<Integer> r = quickSort.doSort(dataList,SortType.ASC);
		System.out.println(r);

	}

}
