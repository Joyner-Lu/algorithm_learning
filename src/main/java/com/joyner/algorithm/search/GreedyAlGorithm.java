package com.joyner.algorithm.search;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.joyner.common.util.collection.SetUtils;

/**
 * greedy algorithm
 * 
 * @author Joyner-Lu
 * @date 2018-04-25 16:45:26
 *
 */
public class GreedyAlGorithm {

	public Set<String> collectionCovered(Set<String> statesNeeded, Map<String, Set<String>> stations) {
		doValidate(stations);
		Set<String> finalStations = new LinkedHashSet<String>();
		Map<String, Boolean> selectedStations = new HashMap<String, Boolean>();

		while (statesNeeded.size() != 0) {

			Set<String> statesCoverd = null;
			String bestStation = null;
			for (String station : stations.keySet()) {
				// check if the station has been checked.
				if (selectedStations.get(station) == null || !selectedStations.get(station)) {
					Set<String> states = stations.get(station);
					Set<String> covered = SetUtils.intersection(states, statesNeeded);
					if (statesCoverd == null) {
						statesCoverd = covered;
						bestStation = station;
					} else {
						if (covered.size() > statesCoverd.size()) {
							// update
							statesCoverd = covered;
							bestStation = station;
						}
					}
				}

			}
			selectedStations.put(bestStation, true);
			finalStations.add(bestStation);
			statesNeeded = SetUtils.difference(statesNeeded, statesCoverd);
		}

		return finalStations;

	}

	private static Set<String> initStatesNeeded() {
		Set<String> statesNeeded = new LinkedHashSet<String>();
		SetUtils.initSet(statesNeeded, "mt", "wa", "or", "id", "nv", "ut", "ca", "az");
		return statesNeeded;
	}

	private void doValidate(Map<String, Set<String>> stations) {
		if (stations == null) {
			throw new RuntimeException("parameter stations mustn't be not null,please check it!");
		}

	}
	
	public static void main(String[] args) {
		Map<String, Set<String>> stations = new HashMap<String, Set<String>>();
		stations.put("kone", SetUtils.initSet("id", "nv", "ut"));
		stations.put("ktwo", SetUtils.initSet("id", "wa", "mt"));
		stations.put("kthree", SetUtils.initSet("or", "nv", "ca"));
		stations.put("kfour", SetUtils.initSet("nv", "ut"));
		stations.put("kfive", SetUtils.initSet("ca", "az"));
		
		Set<String> statesNeeded = initStatesNeeded();
		
		GreedyAlGorithm greedyAlGorithm = new GreedyAlGorithm();
		Set<String> result = greedyAlGorithm.collectionCovered(statesNeeded, stations);
		System.out.println(result);

	}

}
