package com.petmatch.PetMatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetController {
	@Autowired
	PetService ps;
	
	@RequestMapping("/result")
	public ModelAndView handleCallBack(@RequestParam("code") String code) { 
		System.out.println(code);
		
		String token = ps.getToken(code);
		System.out.println(token);
		return new ModelAndView("redirect:/");
	}			
	
}
