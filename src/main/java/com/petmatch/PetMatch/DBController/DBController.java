package com.petmatch.PetMatch.DBController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.apiService.PetService;
import com.petmatch.PetMatch.repo.PetsRepo;

@RestController
public class DBController {

	@Value("${pet.key}")
	String petKey;
	
	@Autowired
	PetService ps;
	
	RestTemplate rt = new RestTemplate();
	
	@Autowired
	PetsRepo pr;
	
	@RequestMapping ("/table")
	public ModelAndView displayTable() {
		System.out.println(pr);
		return new ModelAndView("index", "quest", pr.findAll());

	}
	
	@RequestMapping("/question")
public ModelAndView questOne() {
		return new ModelAndView("question");
	}
	
	
	
//	@RequestMapping ("qa")
//	public ModelAndView qSpace(@RequestParam ("keyword") String keyword) {
//		String[] key = null;
//		key = keyword.split(",");
//
//		for(int i = 0; i < key.length; i++ ) {	
//		}
//		return null;
//	}
//	
	
	
	
	
	
	
}
