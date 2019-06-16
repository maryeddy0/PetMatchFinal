package com.petmatch.PetMatch.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Animals {
	
	private Integer id;//need this id to identify each pet
	private String url;//just to check what this url for.
	
	public Animals() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
}