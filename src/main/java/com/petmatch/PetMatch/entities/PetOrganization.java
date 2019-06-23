package com.petmatch.PetMatch.entities;
// Stassi
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/* API Endpoint: GET https://api.petfinder.com/v2/organizations */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetOrganization {
	
	private Organization organization;
	private String address;
	private ArrayList<Photos> photos;
	
	
	public PetOrganization() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PetOrganization(Organization organization, String address, ArrayList<Photos> photos) {
		super();
		this.organization = organization;
		this.address = address;
		this.photos = photos;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Photos> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<Photos> photos) {
		this.photos = photos;
	}

}
