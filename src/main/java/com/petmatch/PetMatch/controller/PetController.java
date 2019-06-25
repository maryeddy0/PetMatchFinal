package com.petmatch.PetMatch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
import com.petmatch.PetMatch.entities.Pet;
import com.petmatch.PetMatch.entities.PetOrganization;
import com.petmatch.PetMatch.entities.Pets;
import com.petmatch.PetMatch.entityTypes.StoreSelectedPets;
import com.petmatch.PetMatch.pojosDB.History;
import com.petmatch.PetMatch.pojosDB.User;
import com.petmatch.PetMatch.repo.HistoryRepo;
import com.petmatch.PetMatch.repo.UserRepo;

@SessionAttributes("user1")
@Controller
public class PetController {
	@Autowired
	PetService ps;
	@Autowired
	HistoryRepo hr;

	@Autowired
	UserRepo ur;

	RestTemplate rt = new RestTemplate();
	Stack<Integer> stack = new Stack<>();

	@Autowired
	HttpSession session;

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
		type = ps.matchTheTypeNameWithAPI(type);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ps.getToken());

		String url1 = "https://api.petfinder.com/v2/animals?type=" + type + "&size=medium" + "&limit=5";
		ResponseEntity<Pets> petResponse = rt.exchange(url1, HttpMethod.GET, new HttpEntity<>("paramters", headers),
				Pets.class);

		// where I can the method from Petservice: savePetBasicInfoObjectToAList();
		ArrayList<StoreSelectedPets> petsInfo = ps.savePetBasicInfoObjectToAList(petResponse);

		ModelAndView mv = new ModelAndView("details");
		mv.addObject("basicInfo", petsInfo);
		return mv;
	}

	// RequestParam to avoid to create a responseEntity again to call the same thing
	// from before. so I just passed in those primary info
	// Yelp can start in here as a link/map/anything you want to add
	@RequestMapping("/moreDetail")
	public ModelAndView getMoreDetails(@RequestParam("description") String description,
			@RequestParam("photo") String photo, @RequestParam("name") String name,
			@RequestParam("orgID") String organizationID, @RequestParam("petID") Integer petID) {
		// some description has null value, will add validation for it later on
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + ps.getToken());
		String url1 = "https://api.petfinder.com/v2/organizations/" + organizationID;

		ResponseEntity<PetOrganization> orgResponse = rt.exchange(url1, HttpMethod.GET,
				new HttpEntity<>("paramters", headers), PetOrganization.class);

		StoreSelectedPets s = new StoreSelectedPets(photo, name, description);// display on both details page and
																				// description and contact page

		ModelAndView mv = new ModelAndView("descriptionAndContact-page");

		mv.addObject("basic", s);
		mv.addObject("contacts", orgResponse.getBody().getOrganization());
		/************************************************/

		String url2 = "https://api.petfinder.com/v2/animals/" + petID;// endpoint
		ResponseEntity<Pet> petIDResponse = rt.exchange(url2, HttpMethod.GET, new HttpEntity<>("paramters", headers),
				Pet.class);
		String orgId = petIDResponse.getBody().getAnimal().getOrganization_id();
		String petName = petIDResponse.getBody().getAnimal().getName();
		String petPhoto = petIDResponse.getBody().getAnimal().getPhotos().get(0).getMedium();

		String url = "https://api.petfinder.com/v2/organizations/" + orgId;
		ResponseEntity<PetOrganization> orgIDResponse = rt.exchange(url1, HttpMethod.GET,
				new HttpEntity<>("paramters", headers), PetOrganization.class);

		String petEmail = orgIDResponse.getBody().getOrganization().getEmail();
		String petPhone = orgIDResponse.getBody().getOrganization().getPhone();
		String petOrgName = orgIDResponse.getBody().getOrganization().getName();
		User userFromDBContoller = (User) session.getAttribute("user1");
		hr.save(new History(userFromDBContoller.getUserid(), petID, petPhoto, petName, petEmail, petPhone, petOrgName));
		// this where to start use the ID to get infor from API
		mv.addObject("viewedPetBasic", s);
		mv.addObject("contact", orgResponse.getBody().getOrganization());
		User userHistory = (User) session.getAttribute("user1");
		List<History> history = hr.findByUserid(userHistory.getUserid());
		mv.addObject("view", history);

		/**************************************************/
		return mv;
	}

}
