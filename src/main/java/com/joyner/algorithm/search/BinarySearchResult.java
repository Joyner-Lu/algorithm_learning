package com.joyner.algorithm.search;

public class BinarySearchResult<T extends Comparable<T>> {
	
	private int location = -1;
	private int searchTimes;
	
	public BinarySearchResult() {
		
	}
	
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}

	public int getSearchTimes() {
		return searchTimes;
	}

	public void setSearchTimes(int searchTimes) {
		this.searchTimes = searchTimes;
	}

	@Override
	public String toString() {
		return "BinarySearchResult [location=" + location + ", searchTimes=" + searchTimes + "]";
	}
	
	
	
}
