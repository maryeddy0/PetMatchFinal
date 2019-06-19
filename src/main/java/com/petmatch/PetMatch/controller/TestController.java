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
<<<<<<< HEAD:src/main/java/com/petmatch/PetMatch/controller/TestController.java
	
	@RequestMapping("/quest")
	public ModelAndView questToAnswers() {
		return new ModelAndView("answers");
	}
=======

<<<<<<< Updated upstream
>>>>>>> 349c0872cf45e2a4e782ce91dae72be578c5d029:src/main/java/com/petmatch/PetMatch/controller/QuestionController.java


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
