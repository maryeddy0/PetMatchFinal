package com.petmatch.PetMatch.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YelpController {
	@Value("${yelp.key}")
	String yelpKey;
	
	
	RestTemplate rt = new RestTemplate();
	@RequestMapping("to-yelp")
	public ModelAndView getYelp() {
		ModelAndView mv = new ModelAndView("index");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer "+yelpKey);
		String location="Dearborn,MI"; //this is where we need to take location input from user
		String term="pets";
		String url = "https://api.yelp.com/v3/businesses/search?location="+location+"&term="+term;
		ResponseEntity<String> yelpResponse = rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), String.class);
		mv.addObject("yelp", yelpResponse.getBody());
		return mv;
	}

}
