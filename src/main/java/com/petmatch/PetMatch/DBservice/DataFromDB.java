package com.petmatch.PetMatch.DBservice;

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
	public List<String> getTypes(){
		List<String> petTypeDB = pr.getType();
		return petTypeDB;
	} 
	
	//store the keywords from pets database into a list
	public List<String> getKeywords(){
		List<String> keywordsList = pr.getKeywords();
		return keywordsList; 
	}
	
	//check match 	
	public Map<String, Integer> checkMatch(String str) {
		Map<String, Integer> matchRate = new HashMap<>(); 
//		String str = "outdoor";//assuming the input is "outdoor" => just testing
//		
		for(int i = 0; i < getKeywords().size(); i++) { //getKeywords() = access the method called getKeywords(), that method return a list.
			if(getKeywords().get(i).contains(str)) {  //check the index in this keywordsList to see if the input matches any word in the keywords list(look up database)
				if(matchRate.containsKey(getTypes().get(i))) {// check if the hash map has already have the type listed in
					incrementValue(matchRate, getTypes().get(i)); // if the hash-map contains the key, just increase it's value by 1. incrementValue() is a method I build below
				}
				else{
					matchRate.put(getTypes().get(i), 1); //if the hash map doesn't contain the key, then it will add this key into hash map and a value 1.
				}
			}
		}
		return matchRate;  //after this,  we can compare the match rate(from the value in the hash-map) for each pet type, then continue next step
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
