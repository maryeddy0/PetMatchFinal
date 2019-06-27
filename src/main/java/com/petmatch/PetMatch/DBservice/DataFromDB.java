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

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petmatch.PetMatch.pojosDB.User;
import com.petmatch.PetMatch.repo.PetsRepo;
import com.petmatch.PetMatch.repo.UserRepo;

/*...NOTE...*/
/* made this class to separate methods for API. Methods are for database stays in this class/package */

@Component
public class DataFromDB {

	@Autowired
	PetsRepo pr;
	
	@Autowired
	UserRepo ur;
	
	@Autowired
	HttpSession session;

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

	// store user inputs into a List
	// return the list called ls
	public List<String> storeInputsIntoAList(String space, String size, String interact, String cost, String hours,
			String mess, String bath, String friend) {
		List<String> ls = new ArrayList<>(
				Arrays.asList(space, size, interact, cost, hours, mess, bath, friend));
		return ls;
	}

	// sorted their value for displaying the match bars in order
	// store the sorted match result to hashMap
	// return the sorted hashMap to the controller class
	public Map<String, Double> storeMatchInHashMap(String space, String size, String interact, String cost,
			String hours, String mess, String bath, String friend) {
		Map<String, Double> matchRate = new HashMap<>();
		checkMatch(storeInputsIntoAList(space, size, interact, cost, hours, mess, bath, friend), matchRate);

		// sorted them by its value
		Map<String, Double> valueSortedMap = valueSortHashMapValue(matchRate);
		return valueSortedMap;
	}

	// sort map value : needs to do more research about this one
	// return sorted hash map to stroreMatchInHashMap()
	public Map<String, Double> valueSortHashMapValue(Map<String, Double> matchRate) {
		List<Entry<String, Double>> list = new LinkedList<Entry<String, Double>>(matchRate.entrySet());
		Collections.sort(list, new MyComparator().reversed()); // check <ComparetorForSort> Class

		Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
		for (Entry<String, Double> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	// check match by loop through user inputs and keywords string
	public void checkMatch(List<String> ls, Map<String, Double> matchRate) {
		for (int j = 0; j < ls.size(); j++) { // this ls is the user input/keywords list
			for (int i = 0; i < storeTypes().size(); i++) { // check keywords/String size
				if (storeKeywords().get(i).contains(ls.get(j))) {// keywords column contains user input
					if (matchRate.containsKey(storeTypes().get(i))) {// if the hash-map has the key/type
						incrementValue(matchRate, storeTypes().get(i));// only increase its value
					} else {
						matchRate.put(storeTypes().get(i), 12.50);
					}
				}
			}
		}
	}

	// if the type is already in the hash-map(in above method tells details), then
	// just increment the its value
	public void incrementValue(Map<String, Double> map, String type) {
		Double count = map.get(type); // get the value of this certain key.
		map.put(type, count + 12.50); // use the same key. but add its value by 1.
	}
	
	//check if the email exist in the DB
	//no return
	public void checkEmailInDB(String email) {
		User user;
		if(ur.findByEmail(email) == null) {//if not find
			user = new User(email);
			ur.save(user);
			session.setAttribute("user1", user); //Binds an object to this session, using the name specified.
		}else{
			user = ur.findByEmail(email); //find the specific email if exists in the table
			session.setAttribute("user1", user);//(String name, Object value), no return
		}
	}


}
