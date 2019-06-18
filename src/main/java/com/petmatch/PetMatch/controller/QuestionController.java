package com.petmatch.PetMatch.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	return	new ModelAndView("quest");
	}

	@RequestMapping("/spaces")
	public ModelAndView qSpace(@RequestParam("space") String space) {
		db.checkMatch(space);
		return new ModelAndView("answer", "", db);
	}

//		@RequestMapping("")
//		public ModelAndView 

}
