package com.petmatch.PetMatch.apiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.petmatch.PetMatch.entities.Pet;
import com.petmatch.PetMatch.entities.Pets;
import com.petmatch.PetMatch.entityTypes.StoreSelectedPets;

@Component
public class PetService {
	@Value("${pet.key}")
	String petKey;

	RestTemplate rt = new RestTemplate();

	// get token from PetFinderAPI
	// return the token to controller
	public String getToken() {
		Map<String, String> params = new HashMap<>();
		params.put("grant_type", "client_credentials");
		params.put("client_id", petKey);
		params.put("client_secret", "ATzD0I5Kl6f6FL0OQYQpmAZlc3Pmx70BQcBLCotV");

		RestTemplate rt = new RestTemplate();
		@SuppressWarnings("unchecked") // Q for TA/Instructor: is this ok to add in order to get rid of warning below??
		Map<String, String> response = rt.postForObject("https://api.petfinder.com/v2/oauth2/token", params, Map.class);
		return response.get("access_token");
	}

	// get Type from user, and match the type with API type name
	// return the sepcific type
	public String matchTheTypeNameWithAPI(String type) {


		 if (type.equalsIgnoreCase("reptile")) {
			type = "scales-fins-other";
		} else if (type.equalsIgnoreCase("scales")) {
			type = "small-furry";
		}
		return type;
	}

	// create a ArrayList holds different objects
	// method call: getResponseForEachPet()
	// return the ArrayList
	public ArrayList<StoreSelectedPets> savePetBasicInfoObjectToAList(ResponseEntity<Pets> petResponse) {
		ArrayList<StoreSelectedPets> petsInfo = new ArrayList<>();
		//store the objects to arraylist and display in jsp page
		for (int i = 0; i < petResponse.getBody().getAnimals().size(); i++) {
			Integer petID = petResponse.getBody().getAnimals().get(i).getId(); // pet ID
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + getToken());
			String url2 = "https://api.petfinder.com/v2/animals/" + petID;//endpoint
			ResponseEntity<Pet> petIDResponse = rt.exchange(url2, HttpMethod.GET, new HttpEntity<>("paramters", headers),
					Pet.class);//get Json Repsonse
			StoreSelectedPets ssp = new StoreSelectedPets();  
			ssp = createPetBasicInfo(petIDResponse, ssp, petID); // method call //the ID here just helps to stack to trace which pet user viewed
			petsInfo.add(ssp);
//			addPetToArrayList(petsInfo, petID);
		}
//		getResponseForEachPet(petResponse, petsInfo);
		return petsInfo;
	}
	
	public StoreSelectedPets createPetBasicInfo(ResponseEntity<Pet> petIDResponse, StoreSelectedPets ssp,
			Integer petID) {
		// check the photo from API is not empty
		// there is definitely a better way to do the same thing here, I just don't know
		// yet.
		if (petIDResponse.getBody().getAnimal().getPhotos().isEmpty()) {
			ssp.setPhotos("https://smhttp-ssl-50970.nexcesscdn.net/media/catalog/product/cache/1/image/300x/9df78eab33525d08d6e5fb8d27136e95/placeholder/default/no_image_available_3.jpg");
			ssp = new StoreSelectedPets(ssp.getPhotos(), petIDResponse.getBody().getAnimal().getName(),
					petIDResponse.getBody().getAnimal().getAge(), petIDResponse.getBody().getAnimal().getGender(),
					petIDResponse.getBody().getAnimal().getDescription(),
					petIDResponse.getBody().getAnimal().getOrganization_id(), petID);
		} else {
			ssp = new StoreSelectedPets(petIDResponse.getBody().getAnimal().getPhotos().get(0).getMedium(),
					petIDResponse.getBody().getAnimal().getName(), petIDResponse.getBody().getAnimal().getAge(),
					petIDResponse.getBody().getAnimal().getGender(),
					petIDResponse.getBody().getAnimal().getDescription(),
					petIDResponse.getBody().getAnimal().getOrganization_id(), petID);
		}
		return ssp;
	}

}
