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
import com.petmatch.PetMatch.pojosDB.History;
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
            @RequestParam(name = "mess", required = false) String mess,
            @RequestParam(name = "bath", required = false) String bath,
            @RequestParam(name = "friend", required = false) String friend,
            @RequestParam(name = "eat", required = false) String eat,
            @RequestParam(name = "dress", required = false) String dress) {
        ModelAndView mv = new ModelAndView("answers");
        mv.addObject("space",db.storeMatchInHashMap(space, size, interact, cost, hours, mess, bath, friend, eat, dress));
        return mv;
    }
    
	@RequestMapping("/quiz")
	public ModelAndView indexToQuestions(@RequestParam("email") String email) {
		User user;
		if(ur.findByEmail(email) == null) {//if not find
			user = new User(email);
			ur.save(user);
			session.setAttribute("user1", user); //Binds an object to this session, using the name specified.
		}else{
			user = ur.findByEmail(email); //find the specific email if exists in the table
			session.setAttribute("user1", user);//(String name, Object value), no return
		}
		return new ModelAndView("quest");
	}
	
	@RequestMapping("/viewedPet")
	public ModelAndView getViewedHistory(@RequestParam("petPhoto") String petPhoto, 
										 @RequestParam("petName") String petName,
										 @RequestParam("contactEmail") String contactEmail,
										 @RequestParam("contactPhone") String contactPhone,
										 @RequestParam("orgName") String orgName){
		History viewedPet= new History(petPhoto, petName, contactEmail, contactPhone, orgName);
		return new ModelAndView("viewedPet-page", "viewedPetInfo",viewedPet);	
	}
}
