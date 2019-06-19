package com.petmatch.PetMatch.DBservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.petmatch.PetMatch.repo.PetsRepo;

/*...NOTE...*/
/* made this class to separate methods for API. Methods are for database stays in this class/package */

@Component
public class DataFromDB {

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

	// store the match result to hashMap
	public Map<String, Integer> storeMatchInHashMap(String space, String interact, String cost, String hours,
			String noise) {

		Map<String, Integer> matchRate = new HashMap<>();
		checkMatch(storeInputsIntoAList(space, interact, cost, hours, noise), matchRate);

		return matchRate;
	}

	//check match by loop through types, user inputs and keywords string
	private void checkMatch(List<String> ls, Map<String, Integer> matchRate) {

		//Q: should I extract below to 2 more method???? good practice?
		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < storeKeywords().size(); j++) {
//				for (int k = 0; k < storeTypes().size(); k++) {
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
