package com.petmatch.PetMatch.DBservice;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.petmatch.PetMatch.repo.PetsRepo;


/*...NOTE...*/
/* made this class to separate methods for API. Methods are for database stays in this class/package */




@Component
public class DataFromDB {
	
	@Autowired
	PetsRepo pr;
	
	
	public HashMap<String, String> getTypeAndKeywords(){
		List<String> typePet = pr.getType();//store the types from pets database into a list 
		List<String> keywordsList = pr.getKeywords(); //store the keywords from pets database into a list
		
		//initialize a hashMap
		HashMap<String, String> typeAndKeywords = new HashMap<>();
		
		//store the two lists into a hash map in order to make them as key value pair 
		for(int i = 0; i < typePet.size(); i++) {
			typeAndKeywords.put(typePet.get(i), keywordsList.get(i));
		}
		
		return typeAndKeywords;
		
	}
}
