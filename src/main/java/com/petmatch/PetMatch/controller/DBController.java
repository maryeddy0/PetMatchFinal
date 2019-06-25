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
			@RequestParam(name = "mess", required = false) String mess) {
		ModelAndView mv = new ModelAndView("answers");
		System.out.println("space: " + space);
		mv.addObject("space",db.storeMatchInHashMap(space, size, interact, cost, hours, mess));
		return mv;
	}
	
	//URL: quiz
	//this method simplely just links the first home page to the question page
	@RequestMapping("/quiz")
	public ModelAndView indexToQuestions() {
		return new ModelAndView("quest");
	}
	

//	//just testing if JPA gets the data from database.
//	@RequestMapping("/table")
//	public ModelAndView displayTable() {
//		System.out.println(pr);
//		return new ModelAndView("index", "quest", pr.findAll());
//	}
}
