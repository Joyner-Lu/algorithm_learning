package com.joyner.common.util.collection;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set operations: union, intersection, difference, symmetric difference, is
 * subset, is superset
 * 
 * @author Joyner-Lu
 * @date 2018-04-25 17:15:09
 *
 */
public class SetUtils {

	public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
		Set<T> tmp = new TreeSet<T>(setA);
		tmp.addAll(setB);
		return tmp;
	}

	public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
		Set<T> tmp = new TreeSet<T>();
		for (T x : setA)
			if (setB.contains(x))
				tmp.add(x);
		return tmp;
	}

	public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
		Set<T> tmp = new TreeSet<T>(setA);
		tmp.removeAll(setB);
		return tmp;
	}

	public static <T> Set<T> symDifference(Set<T> setA, Set<T> setB) {
		Set<T> tmpA;
		Set<T> tmpB;
		tmpA = union(setA, setB);
		tmpB = intersection(setA, setB);
		return difference(tmpA, tmpB);
	}

	public static <T> boolean isSubset(Set<T> setA, Set<T> setB) {
		return setB.containsAll(setA);
	}

	public static <T> boolean isSuperset(Set<T> setA, Set<T> setB) {
		return setA.containsAll(setB);
	}
	
	/**
	 * 
	 * @param set
	 * @param datas
	 * @return
	 */
	public static <T> Set<T> initSet(Set<T> set,T... datas) {
		for (T data : datas) {
			set.add(data);
		}
		return set;
		
	}
	
	public static <T> Set<T> initSet(T... datas) {
		Set<T> set = new LinkedHashSet<T>();
		for (T data : datas) {
			set.add(data);
		}
		return set;
		
	}

}
