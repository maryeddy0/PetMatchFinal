package com.petmatch.PetMatch.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.petmatch.PetMatch.entities.PetOrganization;
import com.petmatch.PetMatch.entities.PetTypes;
import com.petmatch.PetMatch.entities.Pets;
import com.petmatch.PetMatch.entityTypes.StoreSelectedPets;

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
	
	
	//URL link: selected
	//required param: String type
	//model "basicInfor" with value "petsInfo"
	//view page: details
	@RequestMapping("/selected")
	public ModelAndView detailedInfo(@RequestParam("type") String type) {
		type = ps.matchTheTypeNameWithAPI(type);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ps.getToken());

		String url1 = "https://api.petfinder.com/v2/animals?type=" + type + "&size=medium" + "&limit=10";
		ResponseEntity<Pets> petResponse = rt.exchange(url1, HttpMethod.GET, new HttpEntity<>("paramters", headers),
				Pets.class);

		ArrayList<StoreSelectedPets> petsInfo = ps.savePetBasicInfoObjectToAList(headers, petResponse);
		
		ModelAndView mv = new ModelAndView("details");
		mv.addObject("basicInfo", petsInfo);
		return mv;
	}
	
	// RequestParam to avoid to create a responseEntity again to call the same thing from before. so I just passed in those primary info
	// Yelp can start in here as a link/map/anything you want to add
	@RequestMapping("/moreDetail")
	public ModelAndView getMoreDetails(@RequestParam("description") String description,
									   @RequestParam("photo") String photo,
									   @RequestParam("name") String name,
									   @RequestParam("orgID") String organizationID) {
		//some description has null value, will add validation for it later on
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ps.getToken());
		String url1="https://api.petfinder.com/v2/organizations/" + organizationID;
		
		ResponseEntity<PetOrganization> orgResponse= rt.exchange(url1, HttpMethod.GET, new HttpEntity<>("paramters", headers), PetOrganization.class);		
		StoreSelectedPets s = new StoreSelectedPets(photo, name, description);
		ModelAndView mv =  new ModelAndView("descriptionAndContact-page");
		mv.addObject("basic",s);
		mv.addObject("contacts", orgResponse.getBody().getOrganization());
		return mv;
	}

//	@RequestMapping("/selected")
//	public ModelAndView selectedPets(@RequestParam("type") String type) {
//		if(type.equalsIgnoreCase("fish")) {
//			type="scales-fins-other";
//		}else if(type.equalsIgnoreCase("scale")) {
//			type="scales-fins-other";
//		}else if(type.equalsIgnoreCase("smallfurry")) {
//			type="small-furry";
//		}
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization","Bearer " + ps.getToken());	
////		String type = "dog";
//		String size="medium";
//		Integer limit=15;
//		Integer id;
//		String url = "https://api.petfinder.com/v2/animals?type="+type+"&size="+size+"&limit="+limit;
//
//		ResponseEntity<Pets> petResponse= rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), Pets.class);
//
//		ModelAndView mv = new ModelAndView("display-selected");
//		mv.addObject("type", type);
//		mv.addObject("display", petResponse.getBody().getAnimals());
//		return mv;
//	}
//	
//	@RequestMapping("/detail")
//	public ModelAndView detailedInfo(@RequestParam("id") Integer animalId ) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization","Bearer " + ps.getToken());	
//		String url ="https://api.petfinder.com/v2/animals/" + animalId;
//		
//		ResponseEntity<Pet> petResponse = rt.exchange(url, HttpMethod.GET, new HttpEntity<>("paramters", headers), Pet.class);
//		ModelAndView mv = new ModelAndView("details");
//				
//		mv.addObject("detailedinfo",petResponse.getBody().getAnimal());
//		System.out.println(petResponse.getBody().getAnimal());
//		String orgId = petResponse.getBody().getAnimal().getOrganization_id();
//		String url1="https://api.petfinder.com/v2/organizations/" + orgId;
//		
//		ResponseEntity<PetOrganization> orgResponse= rt.exchange(url1, HttpMethod.GET, new HttpEntity<>("paramters", headers), PetOrganization.class);
////		System.out.println("Name: " + orgResponse.getBody().getOrganization().getName());
//		
//		mv.addObject("organization", orgResponse.getBody().getOrganization().getName());
//		mv.addObject("telephone", orgResponse.getBody().getOrganization().getPhone());
//		mv.addObject("city", orgResponse.getBody().getOrganization().getAddress().getCity());
//		mv.addObject("state", orgResponse.getBody().getOrganization().getAddress().getState());
//		mv.addObject("postcode", orgResponse.getBody().getOrganization().getAddress().getPostcode());
//
//		
//		try {
//			mv.addObject("picture", petResponse.getBody().getAnimal().getPhotos().get(0).getMedium());
//		} catch (Exception e) {
//			mv.addObject("picture", null);
//			e.printStackTrace();
//		}
//
//		return mv;
//	}


	
}
