package com.petmatch.PetMatch.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.entities.Businesses;

@Controller
public class YelpController {
	@Value("${yelp.key}")
	String yelpKey;
	
	
	RestTemplate rt = new RestTemplate();
	@RequestMapping("/zipcodeinfo")
	public ModelAndView getZipCode() {

		return new ModelAndView("yelp");
	}
	
	@RequestMapping("/resultsyelp")
	public ModelAndView getInfoYelp(@RequestParam("zipcode") String zipcode) {
		ModelAndView mv = new ModelAndView("yelpresults");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer "+ yelpKey);
		String location=zipcode; //this is where we need to take location input from user
		String categories="animalshelters,petadoption,petstore";
		String url = "https://api.yelp.com/v3/businesses/search?location="+location+"&term=pets"+"&categories="+ categories+"&limit=10";
//		ResponseEntity<String> yelpResponse = rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), String.class);
		ResponseEntity<Businesses> yelpResponse = rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), Businesses.class);

		mv.addObject("yelpinfo", yelpResponse.getBody().getBusinesses());
		mv.addObject("zipcode", zipcode);
		return mv;
	}

}
