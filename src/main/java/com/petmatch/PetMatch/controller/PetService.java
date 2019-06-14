package com.petmatch.PetMatch.controller;

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
	
	public String getToken(String code) {
		Map<String, String> params = new HashMap<>();
		params.put("code", code);//fix me
		params.put("client_id", petKey);
		params.put("client_secret", "D4NpNeUohjBSVvxPuMQ8FQ9zJbGVP3xPDheK2vzWcopy");
		
		Map<String, String> response = rt.postForObject("https://api.petfinder.com/v2/oauth2/token", params, Map.class);
		return response.get("token");
	}
	
	
}
