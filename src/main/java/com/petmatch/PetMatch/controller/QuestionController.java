package com.petmatch.PetMatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.DBservice.ConnectDBAndInput;
import com.petmatch.PetMatch.repo.PetsRepo;

@Controller
public class QuestionController {

	@Autowired
	ConnectDBAndInput db;

	@Autowired
	PetsRepo pr;

	@RequestMapping("/test")
	public ModelAndView qtest() {
		return new ModelAndView("quest");
	}

<<<<<<< Updated upstream


=======
	@RequestMapping("/spaces")
	public ModelAndView qSpace(@RequestParam("space") String space,
							   @RequestParam("interact") String interaction, 
							   @RequestParam("cost") String cost,
							   @RequestParam("hours") String hours,
						       @RequestParam("hours") String time) {
		return new ModelAndView("answers", "space", db.storeMatchInHashMap(space, interaction, cost, hours, time));
	}

>>>>>>> Stashed changes

}
