package com.petmatch.PetMatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.petmatch.PetMatch.DBservice.DataFromDB;
import com.petmatch.PetMatch.apiService.PetService;
import com.petmatch.PetMatch.repo.PetsRepo;

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
	
	RestTemplate rt = new RestTemplate();


	//just testing if JPA gets the data from database.
	@RequestMapping("/table")
	public ModelAndView displayTable() {
		System.out.println(pr);
		return new ModelAndView("index", "quest", pr.findAll());

	}
}
