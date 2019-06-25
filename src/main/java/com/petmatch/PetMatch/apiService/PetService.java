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

/*this class contains methods that help manipulating data that are relevant to petAPI */

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
		params.put("client_secret", "qevQ78uvL3dzNedhKrWGekeEqjsfXATdL6Obq2Z6");

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
		} else if (type.equalsIgnoreCase("smallfurry")) {
			type = "small-furry";
		}
		return type;
	}

	// create a ArrayList holds different objects
	// method call: getResponseForEachPet()
	// return the ArrayList
	public ArrayList<StoreSelectedPets> savePetBasicInfoObjectToAList(HttpHeaders headers,
			ResponseEntity<Pets> petResponse) {
		ArrayList<StoreSelectedPets> petsInfo = new ArrayList<>();
		getResponseForEachPet(headers, petResponse, petsInfo);
		return petsInfo;
	}

	// loop through ID and get corresponding pet basic info, and add to a ArrayList
	// method call: createPetBasicInfo()
	// no return
	public void getResponseForEachPet(HttpHeaders headers, ResponseEntity<Pets> petResponse,
			ArrayList<StoreSelectedPets> petsInfo) {
		for (int i = 0; i < petResponse.getBody().getAnimals().size(); i++) {
			Integer petID = petResponse.getBody().getAnimals().get(i).getId();

			String url2 = "https://api.petfinder.com/v2/animals/" + petID;
			ResponseEntity<Pet> petIDResponse = rt.exchange(url2, HttpMethod.GET,
					new HttpEntity<>("paramters", headers), Pet.class);

			StoreSelectedPets ssp = new StoreSelectedPets();
			ssp = createPetBasicInfo(petIDResponse, ssp);
			petsInfo.add(ssp);
		}
	}

	// save each pet basic info that requested from API to "StoreSelectedPets"
	// object class
	// return the class reference variable
	public StoreSelectedPets createPetBasicInfo(ResponseEntity<Pet> petIDResponse, StoreSelectedPets ssp) {
		// check the photo from API is not empty
		//there is definitely a better way to do the same thing here, I just don't know yet.
		if (petIDResponse.getBody().getAnimal().getPhotos().isEmpty()) {
			ssp.setPhotos("https://smhttp-ssl-50970.nexcesscdn.net/media/catalog/product/cache/1/image/300x/9df78eab33525d08d6e5fb8d27136e95/placeholder/default/no_image_available_3.jpg");
			ssp = new StoreSelectedPets(ssp.getPhotos(), 
										petIDResponse.getBody().getAnimal().getName(),
										petIDResponse.getBody().getAnimal().getAge(),
										petIDResponse.getBody().getAnimal().getGender(),
										petIDResponse.getBody().getAnimal().getDescription(),
										petIDResponse.getBody().getAnimal().getOrganization_id()
					);
		} else {
			ssp = new StoreSelectedPets(petIDResponse.getBody().getAnimal().getPhotos().get(0).getMedium(),
										petIDResponse.getBody().getAnimal().getName(),
										petIDResponse.getBody().getAnimal().getAge(), 
										petIDResponse.getBody().getAnimal().getGender(),
										petIDResponse.getBody().getAnimal().getDescription(),
										petIDResponse.getBody().getAnimal().getOrganization_id());
		}
		return ssp;
	}
}
