package com.petmatch.PetMatch.entities;
// Stassi
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetOrganization {
	
	private String organization;
	private String address;
	private ArrayList<Photos> photos;
	private Links links;
	
	public PetOrganization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetOrganization(String organization, String address, ArrayList<Photos> photos, Links links) {
		super();
		this.organization = organization;
		this.address = address;
		this.photos = photos;
		this.links = links;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
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

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}
	
	
	
	

}
