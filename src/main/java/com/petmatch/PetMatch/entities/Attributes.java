package com.petmatch.PetMatch.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attributes {
	private String house_trained;//just in case, so I used String type instead of boolean type
	private String special_needs;
	
	public Attributes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getHouse_trained() {
		return house_trained;
	}
	public void setHouse_trained(String house_trained) {
		this.house_trained = house_trained;
	}
	public String getSpecial_needs() {
		return special_needs;
	}
	public void setSpecial_needs(String special_needs) {
		this.special_needs = special_needs;
	}
	
	
	
}
