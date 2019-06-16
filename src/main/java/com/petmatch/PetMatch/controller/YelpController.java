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
//	@Value("${yelp.key}")
//	String yelpKey;
	
	
	RestTemplate rt = new RestTemplate();
	@RequestMapping("to-yelp")
	public ModelAndView getYelp() {
		ModelAndView mv = new ModelAndView("index");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer FXRWBHKYKzTE4sV5U5_TpFG7DiuJ-Ot30GhiopOeCcQD0Vuf4x_Rb9FdwZLVsJ6FXDV9CRH19QtWITUunVN74x_rDdjasMG8TirwZ1T53DlK87hmGCnJA8BFRFsGXXYx");
//		headers.add("client_id","3nqlTcuth53wV6WLxBEigw");
		headers.add("location", "Dearborn, MI");
		
		String url = "https://api.yelp.com/v3/businesses/search";
		ResponseEntity<String> yelpResponse = rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), String.class);
		System.out.println(yelpResponse.getBody());
		return mv;
	}

}
