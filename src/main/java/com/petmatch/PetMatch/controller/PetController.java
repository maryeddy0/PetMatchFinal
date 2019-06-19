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
import com.petmatch.PetMatch.entities.AnimalType;
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
		mv.addObject("basicInfo",petResponse.getBody().getAnimal());
		mv.addObject("photo", petResponse.getBody().getAnimal().getPhotos().get(0).getMedium());
		return mv;
	}
	
<<<<<<< HEAD
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
	
	@RequestMapping("selected")
	public ModelAndView selectedPets() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer " + ps.getToken());	
		String type = "dog";
		String size="large";
		Integer limit=15;
		Integer id;
		String url = "https://api.petfinder.com/v2/animals?type="+type+"&size="+size+"&limit="+limit;

		ResponseEntity<Pets> petResponse= rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), Pets.class);

		ModelAndView mv = new ModelAndView("display-selected");
		mv.addObject("type", type);
		mv.addObject("display", petResponse.getBody().getAnimals());
		return mv;
	}
	
	@RequestMapping("detail")
	public ModelAndView detailedInfo(@RequestParam("id") Integer animalId ) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer " + ps.getToken());	

		String url ="https://api.petfinder.com/v2/animals/" + animalId;
		ResponseEntity<Pet> petResponse= rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), Pet.class);
		
		ModelAndView mv = new ModelAndView("details");
		
		System.out.println("body " + petResponse);
		mv.addObject("detailedinfo",petResponse.getBody().getAnimal());

		try {
			mv.addObject("picture", petResponse.getBody().getAnimal().getPhotos().get(0).getMedium());
		} catch (Exception e) {
			mv.addObject("picture", null);
			e.printStackTrace();
		}

		return mv;
	}
=======
	   @RequestMapping("/types")
	    public ModelAndView getAllTypes() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Authorization","Bearer " + ps.getToken());    
	        
	        String url ="https://api.petfinder.com/v2/types/dog";
	        ResponseEntity<AnimalType> petResponse= rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), AnimalType.class);
	        ModelAndView mv = new ModelAndView("types-page");
	        return new ModelAndView("types-page","allTypes", petResponse.getBody().getType().getName());
	    }
   
	   //Does nothing
	   @RequestMapping("/seeMatch")
	   public ModelAndView getTypeFromAPI(@RequestParam("type") String type) {
		   ModelAndView mv = new ModelAndView();
		   return mv;
	   }
	  
>>>>>>> 02b86fcd9ffe01982cd81e30a2cc88bebca6e736
	
}
