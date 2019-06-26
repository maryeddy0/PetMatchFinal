package com.petmatch.PetMatch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.apiService.PetService;
import com.petmatch.PetMatch.entities.PetOrganization;
import com.petmatch.PetMatch.entities.Pets;
import com.petmatch.PetMatch.entityTypes.StoreSelectedPets;
import com.petmatch.PetMatch.pojosDB.History;
import com.petmatch.PetMatch.repo.HistoryRepo;
import com.petmatch.PetMatch.repo.UserRepo;

@SessionAttributes("user1")//passing through controllers
@Controller
public class PetController {
	@Autowired
	PetService ps;
	
	@Autowired
	HistoryRepo hr;

	@Autowired
	UserRepo ur;

	@Autowired
	HttpSession session; //Provides a way to identify a user across more than one page request or
						//visit to a Web site and to store information about that user.
						//A session usually corresponds to one user, who may visit a site many times.
						// inteface, with alot implemeted methods

	RestTemplate rt = new RestTemplate();

	@RequestMapping("/")
	public ModelAndView index() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ps.getToken());

		ResponseEntity<Pets> petResponse = rt.exchange("https://api.petfinder.com/v2/animals", HttpMethod.GET,
				new HttpEntity<>("paramters", headers), Pets.class);

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("display", petResponse.getBody().getAnimals());
		return mv;
	}

	// URL link: selected
	// required param: String type
	// model "basicInfor" with value "petsInfo"
	// view page: details
	@RequestMapping("/selected")
	public ModelAndView detailedInfo(@RequestParam("type") String type) {
		System.out.println("type :" +type);
		type = ps.matchTheTypeNameWithAPI(type);
		ResponseEntity<Pets> petResponse = ps.getJsonBodyFromAnimalsEndPoint(type);

		ArrayList<StoreSelectedPets> petsInfo = ps.savePetBasicInfoObjectToAList(petResponse);
		
		ModelAndView mv = new ModelAndView("details");
		mv.addObject("basicInfo", petsInfo);
		return mv;
	}



	// RequestParam to avoid to create a responseEntity again to call the same thing from before. so I just passed in those primary info
    // Yelp can start in here as a link/map/anything you want to add
    @RequestMapping("/moreDetail")
    public ModelAndView getMoreDetails(@RequestParam("description") String description,
            @RequestParam(name ="photo", required=false) String photo, @RequestParam("name") String name,
            @RequestParam("orgID") String organizationID, @RequestParam("petID") Integer petID) {
        // some description has null value, will add validation for it later on
        ResponseEntity<PetOrganization> orgResponse = ps.getJsonBodyFromOganizationIDEndPoint(organizationID);
 
        StoreSelectedPets s = new StoreSelectedPets(photo, name, description);
        
        ModelAndView mv = new ModelAndView("descriptionAndContact-page");
		List<History> history = ps.savePetDataToDB(photo, name, petID, orgResponse);
        mv.addObject("basic", s);
        mv.addObject("contacts", orgResponse.getBody().getOrganization());
		mv.addObject("views", history);
		return mv;
	}






}
