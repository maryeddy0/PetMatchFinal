package com.petmatch.PetMatch.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Environment {
	private String children;

	public Environment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}
	
}
