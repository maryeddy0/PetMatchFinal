package com.petmatch.PetMatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.DBservice.DataFromDB;
import com.petmatch.PetMatch.repo.PetsRepo;

@Controller
public class QuestionController {

	@Autowired
	DataFromDB db;

	@Autowired
	PetsRepo pr;

	@RequestMapping("/test")
	public ModelAndView qtest() {
		return new ModelAndView("quest");
	}




}
