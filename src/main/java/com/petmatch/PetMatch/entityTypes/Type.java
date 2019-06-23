package com.petmatch.PetMatch.entityTypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*this class exits only for testing purpose in this project*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {
	private String name;

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
