package com.petmatch.PetMatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionController {
		
		@RequestMapping("/spaces")
		public ModelAndView qSpace(){
			
		return new ModelAndView("quest");
			
		}

		
		
	}

	
	

