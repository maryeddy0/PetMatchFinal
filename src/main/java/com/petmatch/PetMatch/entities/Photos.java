package com.petmatch.PetMatch.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photos {
	private String Medium;

	public Photos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMedium() {
		return Medium;
	}

	public void setMedium(String medium) {
		Medium = medium;
	}
	
	
	
}
