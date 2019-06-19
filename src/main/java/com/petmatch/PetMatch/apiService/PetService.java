package com.petmatch.PetMatch.apiService;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PetService {
	@Value("${pet.key}")
	String petKey;	
	
	RestTemplate rt = new RestTemplate();
	
	//get token from PetFinderAPI
	public String getToken() {
		Map<String, String> params = new HashMap<>();
		params.put("grant_type", "client_credentials");
		params.put("client_id", petKey);
		params.put("client_secret", "ATzD0I5Kl6f6FL0OQYQpmAZlc3Pmx70BQcBLCotV");
		
		RestTemplate rt = new RestTemplate();
		@SuppressWarnings("unchecked")//is this ok to add in order to get rid of warning below??
		Map<String, String> response = rt.postForObject("https://api.petfinder.com/v2/oauth2/token", params, Map.class);
		return response.get("access_token");
	}
	
}
