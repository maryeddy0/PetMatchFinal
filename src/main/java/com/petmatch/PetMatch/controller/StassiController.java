package com.petmatch.PetMatch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.apiService.PetService;
import com.petmatch.PetMatch.entities.Organization;



@Controller
public class StassiController {
	
	
	@Autowired
	PetService os;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/test2")
	public ModelAndView index() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer " + os.getToken());		

		ResponseEntity<Organization> orgResponse = rt.exchange("https://api.petfinder.com/v2/organizations", HttpMethod.GET, new HttpEntity<>("parameters", headers), Organization.class);
		
		ModelAndView mv = new ModelAndView("index");
		System.out.println(orgResponse.getBody());
		mv.addObject("stassidisplay", orgResponse.getBody());
		return mv;
	}
}
