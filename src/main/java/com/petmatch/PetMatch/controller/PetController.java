package com.petmatch.PetMatch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetController {
	@Value("${pet.key}")
	String petKey;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/")
	public ModelAndView index() {
			
		Map<String, String> params = new HashMap<>();
		params.put("grant_type", "client_credentials");
		// client_id and the client_secret (key) is required for the request to get the access token
		params.put("client_id", "SFhCZcxIvWN2ea61KjZIIGJVZmwr0n8SStHj8HkID2pItwRMzz");
		params.put("client_secret", "3I7pl4iCM8xxiFGdECsaMRMg0flTh4XCKu8wcQLJ");
		
		RestTemplate rt = new RestTemplate();
		// we used the postForObject() method because this request is a POST in the Github documentation
		Map<String, String> response = rt.postForObject("https://api.petfinder.com/v2/oauth2/token", params, Map.class);
		System.out.println(response.get("access_token"));
		String url="https://api.petfinder.com/v2/"+response.get("access_token");
	
		return new ModelAndView("index");
	}
	
}
