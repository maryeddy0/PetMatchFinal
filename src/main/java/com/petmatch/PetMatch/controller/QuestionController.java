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
		return new ModelAndView("quest");
	}

	@RequestMapping("/spaces")
	public ModelAndView qSpace(@RequestParam(name = "space", required = false) String space,
			@RequestParam(name = "interact", required = false) String interact,
			@RequestParam(name = "cost", required = false) String cost,
			@RequestParam(name = "hours", required = false) String hours,
			@RequestParam(name = "noise", required = false) String noise) {
		return new ModelAndView("answers", "space", db.checkMatch(space));
	}

//	@RequestMapping("/interact")		
//	public ModelAndView petInteraction(@RequestParam ("interact") String interaction) {
//		return new ModelAndView("answers", "inter", db.checkMatch(interaction));
//	}
//	
//	@RequestMapping("/cost")		
//	public ModelAndView petCost(@RequestParam ("cost") String cost) {
//		return new ModelAndView("answers", "cost", db.checkMatch(cost));
//	}
//	
//	@RequestMapping("/hours")		
//	public ModelAndView petTimeAvailable(@RequestParam ("hours") String hours) {
//		return new ModelAndView("answers", "hours", db.checkMatch(hours));
//	}

}
