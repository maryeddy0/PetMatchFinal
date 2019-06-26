package com.petmatch.PetMatch.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Business {
	private String name;
	private Location location;
	private String display_phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getDisplay_phone() {
		return display_phone;
	}
	public void setDisplay_phone(String display_phone) {
		this.display_phone = display_phone;
	}
	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
