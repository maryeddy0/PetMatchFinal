package com.petmatch.PetMatch.DBservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petmatch.PetMatch.repo.PetsRepo;

/*...NOTE...*/
/*This class contains methods that help manipulate data that are relevant to database  */

@Component
public class DataFromDB {

	@Autowired
	PetsRepo pr;

	// store the types from pets database into a list
	//	return all types called petTypeDB 
	public List<String> storeTypes() {
		List<String> petTypeDB = pr.getType();
		return petTypeDB;
	}

	// store the keywords from pets database into a list
	// return the whole keywords list called keywordsList
	public List<String> storeKeywords() {
		List<String> keywordsList = pr.getKeywords();
		return keywordsList;
	}

	// store user inputs into a List
	// return the list called ls
	private List<String> storeInputsIntoAList(String space, String interact, String cost, String hours, String noise) {
		List<String> ls = new ArrayList<>(Arrays.asList(space, interact, cost, hours, noise));
		return ls;
	}

	// sorted their value for displaying the match bars in order
	// store the sorted match result to hashMap
	// return the sorted hashMap to the controller class
	public Map<String, Integer> storeMatchInHashMap(String space, String interact, String cost, String hours,
			String noise) {
		Map<String, Integer> matchRate = new HashMap<>();
		checkMatch(storeInputsIntoAList(space, interact, cost, hours, noise), matchRate);

		// sorted them by its value
		Map<String, Integer> valueSortedMap = valueSortHashMapValue(matchRate);
		return valueSortedMap;
	}

	// sort map value : needs to do more research about this one
	// return sorted hash map to stroreMatchInHashMap() 
	private Map<String, Integer> valueSortHashMapValue(Map<String, Integer> matchRate) {
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(matchRate.entrySet());
		Collections.sort(list, new MyComparator().reversed()); // check <ComparetorForSort> Class

		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	// check match by loop through user inputs and keywords string
	// return the hashMap
	private void checkMatch(List<String> ls, Map<String, Integer> matchRate) {
		for (int i = 0; i < ls.size(); i++) { //this ls is the user input/keywords list
			for (int j = 0; j < storeKeywords().size(); j++) {
				if (storeKeywords().get(j).contains(ls.get(i))) {//keywords column contains user input
					if (matchRate.containsKey(storeTypes().get(j))) {// if the hash-map has the key/type
						incrementValue(matchRate, storeTypes().get(j));//only increase its value
					} else {
						matchRate.put(storeTypes().get(j), 20);
					}
				}
			}
		}
	}

	// if the type is already in the hash-map(in above method tells details), then
	// just increment the its value
	// return the key and value in a hash map form
	public void incrementValue(Map<String, Integer> map, String type) { 
		Integer count = map.get(type); // get the value of this certain key.
		map.put(type, count + 20); // use the same key. but add its value by 1.
	}
	
	

}
