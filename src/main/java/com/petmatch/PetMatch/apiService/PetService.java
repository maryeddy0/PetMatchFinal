package com.petmatch.PetMatch.apiService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PetService {
	
	RestTemplate rt = new RestTemplate();
	public String getToken() {
		
		Map<String, String> params = new HashMap<>();
		params.put("grant_type", "client_credentials");
		params.put("client_id", "SFhCZcxIvWN2ea61KjZIIGJVZmwr0n8SStHj8HkID2pItwRMzz");
		params.put("client_secret", "3I7pl4iCM8xxiFGdECsaMRMg0flTh4XCKu8wcQLJ");
		
		RestTemplate rt = new RestTemplate();
		@SuppressWarnings("unchecked")//is this ok to add in order to get rid of warning below??
		Map<String, String> response = rt.postForObject("https://api.petfinder.com/v2/oauth2/token", params, Map.class);
		return response.get("access_token");
	}
}
