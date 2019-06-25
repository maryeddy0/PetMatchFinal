package com.petmatch.PetMatch.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.DBservice.DataFromDB;
import com.petmatch.PetMatch.apiService.PetService;
import com.petmatch.PetMatch.pojosDB.User;
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
	HttpSession session;
	@Autowired
	UserRepo ur;

	RestTemplate rt = new RestTemplate();

	// just testing if JPA gets the data from database.
	@RequestMapping("/table")
	public ModelAndView displayTable() {
		System.out.println(pr);
		return new ModelAndView("index", "quest", pr.findAll());
	}

	@RequestMapping("/matchResults")
	public ModelAndView qSpace(@RequestParam(name = "space", required = false) String space,
			@RequestParam(name = "interact", required = false) String interact,
			@RequestParam(name = "cost", required = false) String cost,
			@RequestParam(name = "hours", required = false) String hours,
			@RequestParam(name = "noise", required = false) String noise) {
		ModelAndView mv = new ModelAndView("answers");
		mv.addObject("space", db.storeMatchInHashMap(space, interact, cost, hours, noise));
//		mv.addObject("maxType", db.storeMatchInHashMap(space, interact, cost, hours, noise));
		return mv;
	}

	@RequestMapping("/quiz")
	public ModelAndView indexToQuestions(@RequestParam("email") String email) {
		User user;
		if(ur.findByEmail(email) == null) {
			user = new User(email);
			ur.save(user);
			session.setAttribute("user1", user);
		}else{
			user = ur.findByEmail(email);
			session.setAttribute("user1", user);
		}

		return new ModelAndView("quest");
	}
	
	

//	@RequestMapping("/quest")
//	public ModelAndView questToAnswers() {
//		return new ModelAndView("answers");
//	}

}
