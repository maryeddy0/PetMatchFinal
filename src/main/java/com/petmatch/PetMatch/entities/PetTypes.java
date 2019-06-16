package com.petmatch.PetMatch.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetTypes {
	private ArrayList<Types> types;

	public PetTypes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Types> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<Types> types) {
		this.types = types;
	}
	
	
}
