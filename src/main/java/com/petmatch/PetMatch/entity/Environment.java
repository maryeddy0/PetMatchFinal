package com.petmatch.PetMatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Environment {
	private String children;
	private String dogs;
	private String cats;
	
	
	public Environment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Environment(String children, String dogs, String cats) {
		super();
		this.children = children;
		this.dogs = dogs;
		this.cats = cats;
	}


	public String getChildren() {
		return children;
	}


	public void setChildren(String children) {
		this.children = children;
	}


	public String getDogs() {
		return dogs;
	}


	public void setDogs(String dogs) {
		this.dogs = dogs;
	}


	public String getCats() {
		return cats;
	}


	public void setCats(String cats) {
		this.cats = cats;
	}
	
	
}
