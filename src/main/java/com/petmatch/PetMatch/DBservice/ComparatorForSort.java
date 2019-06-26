package com.petmatch.PetMatch.DBservice;

import java.util.Comparator;
import java.util.Map.Entry;

//create a Comparator
class MyComparator implements Comparator<Entry<String, Double>> {
	//	It compares the first object(Entry<String, Integer> o1) with the second object(Entry<String, Integer> o2).
	public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
		return o1.getValue().compareTo(o2.getValue()); //just compare its value
	}
}

