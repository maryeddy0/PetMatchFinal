package com.petmatch.PetMatch.controller;


import org.springframework.beans.factory.annotation.Autowired;
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

import com.petmatch.PetMatch.apiService.PetService;
import com.petmatch.PetMatch.entities.Pet;
import com.petmatch.PetMatch.entities.PetTypes;
import com.petmatch.PetMatch.entities.Pets;

@Controller
public class PetController {
	@Autowired
	PetService ps;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/")
	public ModelAndView index() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer " + ps.getToken());		

		ResponseEntity<Pets> petResponse= rt.exchange("https://api.petfinder.com/v2/animals", HttpMethod.GET, new HttpEntity<>("paramters", headers), Pets.class);
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("display", petResponse.getBody().getAnimals());
		return mv;
	}
	
	@RequestMapping("send-animalId")
	public ModelAndView getAnimalInfo(@RequestParam("id") Integer animalId ) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer " + ps.getToken());	
		
		String url ="https://api.petfinder.com/v2/animals/" + animalId;
		ResponseEntity<Pet> petResponse= rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), Pet.class);
		
		ModelAndView mv = new ModelAndView("animal-basic-info");
//		mv.addObject("photo", petResponse.getBody().getAnimal());
		mv.addObject("basicInfo",petResponse.getBody().getAnimal());
		mv.addObject("photo", petResponse.getBody().getAnimal().getPhotos().get(0).getMedium());
		return mv;
	}
	
	@RequestMapping("/types")
	public ModelAndView getAllTypes() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer " + ps.getToken());	
		
		String url ="https://api.petfinder.com/v2/types";
		ResponseEntity<PetTypes> petResponse= rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), PetTypes.class);
		
		ModelAndView mv = new ModelAndView("types-page");
//		mv.addObject("photo", petResponse.getBody().getAnimal());
		mv.addObject("allTypes",petResponse.getBody().getTypes());
		return mv;
	}
	
	//hasn't test this one yet. 
//	@RequestMapping("/send-id")
//	public ModelAndView matchingAnimalId(@RequestParam("id") String orgId) {  
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization","Bearer " + ps.getToken());	
//		
//		String url ="https://api.petfinder.com/v2/organizations/"+orgId;
//		ResponseEntity<Pets> petResponse= rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), Pets.class);
//		
//		ModelAndView mv = new ModelAndView("location-page");
//		mv.addObject("displayAddress", petResponse.getBody());
//		
//		return mv;
//	}
	
}
