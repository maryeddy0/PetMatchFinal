package com.petmatch.PetMatch.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Businesses {
	private ArrayList<Business> businesses;

	public ArrayList<Business> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(ArrayList<Business> businesses) {
		this.businesses = businesses;
	}

	public Businesses() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
