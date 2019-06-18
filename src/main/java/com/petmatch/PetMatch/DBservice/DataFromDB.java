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
	
	//check match in terms of budget
	public Map<String, Integer> checkBudget() {
		Map<String, Integer> matchRate = new HashMap<>(); 
		String str = "outdoor";//assuming the input is "outdoor" = testing
		
		int counter = 0;
		for(int i = 0; i < getKeywords().size(); i++) {
			if(getKeywords().get(i).contains(str)) {
				if(matchRate.containsKey(getTypes().get(i))) {
					incrementValue(matchRate, getTypes().get(i));
				}
				else{
					matchRate.put(getTypes().get(i), counter++);
				}
			}
		}
		return matchRate;  //after this,  we can compare the match rate(from the value in the hashmap) for each pet type, then continue next step
	}
	
	//if the type is already in the hashmap(in above method), then just increment its value
	public void incrementValue(Map<String, Integer> map, String k) {
		Integer count = map.get(k);
		if(count == null) {
			count = 0;
		}
		map.put(k, count + 1);
	}
	
}
