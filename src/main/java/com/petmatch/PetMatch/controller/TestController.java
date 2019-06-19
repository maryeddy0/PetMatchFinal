package com.petmatch.PetMatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.DBservice.ConnectDBAndInput;
import com.petmatch.PetMatch.repo.PetsRepo;

@Controller
public class TestController {

	@Autowired
	ConnectDBAndInput db;

	@Autowired
	PetsRepo pr;

	@RequestMapping("/test")
	public ModelAndView indexToQuestions() {
		return new ModelAndView("quest");
	}
	
	@RequestMapping("/quest")
	public ModelAndView questToAnswers() {
		return new ModelAndView("answers");
	}



}
