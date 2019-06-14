package com.petmatch.PetMatch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.entity.Pets;

@Controller
public class PetController {
	@Value("${pet.key}")
	String petKey;
	
	@Autowired
	PetService ps;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/")
	public ModelAndView index() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer " + ps.getToken());
		//String url="https://api.petfinder.com/v2/oauth2/token="+token;
		
		ResponseEntity<Pets> petResponse= rt.exchange("https://api.petfinder.com/v2/animals", HttpMethod.GET, new HttpEntity("paramters",headers), Pets.class);
				
		return new ModelAndView("index","display", petResponse.getBody());
	}
	
}
