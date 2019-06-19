package com.petmatch.PetMatch.DBservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.petmatch.PetMatch.repo.PetsRepo;

/*...NOTE...*/
/* made this class to separate methods for API. Methods are for database stays in this class/package */

@Component
public class ConnectDBAndInput {

	@Autowired
	PetsRepo pr;

	// store the types from pets database into a list
	public List<String> storeTypes() {
		List<String> petTypeDB = pr.getType();
		return petTypeDB;
	}

	// store the keywords from pets database into a list
	public List<String> storeKeywords() {
		List<String> keywordsList = pr.getKeywords();
		return keywordsList;
	}

	// store user inputs into a List, return the list
	private List<String> storeInputsIntoAList(String space, String interact, String cost, String hours, String noise) {
		List<String> ls = new ArrayList<>(Arrays.asList(space, interact, cost, hours, noise));
		return ls;
	}
	
	//sorted their value for display the bars in order
	// store the sorted match result to hashMap
	public  Map<String, Integer> storeMatchInHashMap(String space, String interact, String cost, String hours,
			String noise) {
		Map<String, Integer> matchRate = new HashMap<>();
		checkMatch(storeInputsIntoAList(space, interact, cost, hours, noise), matchRate);		
		 
		//sorted it by its value
		Map<String, Integer> valueSortedMap = valueSortHashMapValue(matchRate);    
		return valueSortedMap;
	}

	//sort map value 
	private Map<String, Integer> valueSortHashMapValue(Map<String, Integer> matchRate) {
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(
			        matchRate.entrySet());
		
			    Collections.sort(list, new MyComparator());
			    Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
			    for (Entry<String, Integer> entry : list) {
			      sortedMap.put(entry.getKey(), entry.getValue());
			    }
			  return sortedMap;
	}
	
	
	
	//check match by loop through user inputs and keywords string
	private void checkMatch(List<String> ls, Map<String, Integer> matchRate) {

		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < storeKeywords().size(); j++) {
					if (storeKeywords().get(j).contains(ls.get(i))) {
						if (matchRate.containsKey(storeTypes().get(j))) {// if the hashmap has the key/type
							incrementValue(matchRate, storeTypes().get(j));
						} else {
							matchRate.put(storeTypes().get(j), 1);
						}
					}
				}
			}
	}

	
	// if the type is already in the hash-map(in above method tells details), then
	// just increment the its value
	public void incrementValue(Map<String, Integer> map, String type) { // type is all defined as key value
		Integer count = map.get(type); // get the value of this certain key.
		map.put(type, count + 1); // use the same key. but add its value by 1.
	}


}
