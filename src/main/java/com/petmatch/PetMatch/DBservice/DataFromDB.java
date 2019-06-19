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
		
	//store the types from pets database into a list 
	public List<String> storeTypes(){
		List<String> petTypeDB = pr.getType();
		return petTypeDB;
	} 
	
	//store the keywords from pets database into a list
	public List<String> storeKeywords(){
		List<String> keywordsList = pr.getKeywords();
		return keywordsList; 
	}
	
	//check match 	
	public Map<String, Integer> storeMatchInHashMap(String space, String interact, String cost, String hours, String time) {
		
		Map<String, Integer> matchRate = new HashMap<>();
		checkMatch(storeInputsIntoAList(space, interact, cost, hours, time), matchRate);
		
		return matchRate; 
	}

	//store user inputs into a List, return the list
	private List<String> storeInputsIntoAList(String space, String interact, String cost, String hours, String time) {
		List<String>  ls = new ArrayList<>(Arrays.asList(space, interact, cost, hours, time));
		return ls;
	}

	
	private void checkMatch(List<String> ls, Map<String, Integer> matchRate) {
		
			for(int i = 0; i < storeKeywords().size(); i++) { 
				
				if(storeKeywords().get(i).contains("FIX ME") { 
					
					if(matchRate.containsKey(storeTypes().get(i))) {//if the hashmap has the key/type
						incrementValue(matchRate, storeTypes().get(i)); 
					}
					else{
						matchRate.put(storeTypes().get(i), 1); 
						}
				}
			}
	}
	
	//if the type is already in the hash-map(in above method tells details), then just increment the its value
	public void incrementValue(Map<String, Integer> map, String k) {
		Integer count = map.get(k);  //get the value of this certain key. remember the values in hash-map are Integer type
		if(count == null) { //just double check in case the key doesn't have a value assigned in 
			count = 0;//give a value so we can increment by adding 1（check next line）
		}
		map.put(k, count + 1); //use the same key. but add its value by 1.
	}
	
	
}
