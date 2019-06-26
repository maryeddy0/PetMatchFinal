package com.petmatch.PetMatch.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
	@JsonProperty("display_address")
	private ArrayList<String> displayaddress;
	
	public ArrayList<String> getDisplayaddress() {
		return displayaddress;
	}
	public void setDisplayaddress(ArrayList<String> displayaddress) {
		this.displayaddress = displayaddress;
	}
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Location [displayaddress=" + displayaddress + "]";
	}
	
	
	

}
