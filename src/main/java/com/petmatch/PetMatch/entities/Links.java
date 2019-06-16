package com.petmatch.PetMatch.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {
	private Self self;
	

	public Links() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Links(Self self) {
		super();
		this.self = self;
	}

	public Self getSelf() {
		return self;
	}

	public void setSelf(Self self) {
		this.self = self;
	}
	
	
	
}
