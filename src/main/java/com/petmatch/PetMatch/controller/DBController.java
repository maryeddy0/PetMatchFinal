package com.petmatch.PetMatch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.DBservice.DataFromDB;
import com.petmatch.PetMatch.apiService.PetService;
import com.petmatch.PetMatch.pojosDB.History;
import com.petmatch.PetMatch.repo.PetsRepo;
import com.petmatch.PetMatch.repo.UserRepo;

@Controller
public class DBController {
	@Value("${pet.key}")
	String petKey;
	
	@Autowired
	PetService ps;
	
	@Autowired
	PetsRepo pr;
	
	@Autowired
	DataFromDB db;
	
	@Autowired
	UserRepo ur;

	RestTemplate rt = new RestTemplate();

	// just testing if JPA gets the data from database.
	@RequestMapping("/table")
	public ModelAndView displayTable() {
		System.out.println(pr);
		return new ModelAndView("index", "quest", pr.findAll());
	}

	//URL: matchResults
    //params: all user question inputs
    //method call: storeMatchInHashMap
    //return the Hash Map that contains the key(the pet type) and corresponding matching rate
    @RequestMapping("/matchResults")
    public ModelAndView qSpace(@RequestParam(name = "space", required = false) String space,
            @RequestParam(name = "size", required = false) String size,
            @RequestParam(name = "interact", required = false) String interact,
            @RequestParam(name = "cost", required = false) String cost,
            @RequestParam(name = "hours", required = false) String hours,
            @RequestParam(name = "mess", required = false) String mess,
            @RequestParam(name = "bath", required = false) String bath,
            @RequestParam(name = "friend", required = false) String friend) {
        ModelAndView mv = new ModelAndView("answers");
        mv.addObject("space",db.storeMatchInHashMap(space, size, interact, cost, hours, mess, bath, friend));
        return mv;
    }
    
	
	//take in 5 params
	//save them into History object and display them on viewedPet-page.jsp
	@RequestMapping("/viewedPet")
	public ModelAndView getViewedHistory(@RequestParam("petPhoto") String petPhoto, 
										 @RequestParam("petName") String petName,
										 @RequestParam("contactEmail") String contactEmail,
										 @RequestParam("contactPhone") String contactPhone,
										 @RequestParam("orgName") String orgName){
		History viewedPet= new History(petPhoto, petName, contactEmail, contactPhone, orgName);
		return new ModelAndView("viewedPet-page", "viewedPetInfo",viewedPet);	
	}
}
