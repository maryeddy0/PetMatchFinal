package com.petmatch.PetMatch.entities;


import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Animal {
	private String type; //might use it for types, not sure yet
	private String organization_id; //need this id to access location
	private Breeds breeds; //need access to the breeds.
	private String age;
	private String gender;
	private String size;
	private String coat;
	private String name;
	private String description;
	private Attributes attributes; //to see if they need special need
	private Environment environment; //check if the pet is good with children
	private Contact contact;
	private Links links;//to check what's in there(have to display it in order to know)
	private ArrayList<Photos> photos;
	
	

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	//set up getter and setter for all in order to access the field
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrganization_id() {
		return organization_id;
	}

	public ArrayList<Photos> getPhotos() {
		return photos;
	}
	public void setPhotos(ArrayList<Photos> photos) {
		this.photos = photos;
	}
	public void setOrganization_id(String organization_id) {
		this.organization_id = organization_id;
	}

	public Breeds getBreeds() {
		return breeds;
	}
	public void setBreeds(Breeds breeds) {
		this.breeds = breeds;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCoat() {
		return coat;
	}
	public void setCoat(String coat) {
		this.coat = coat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public Environment getEnvironment() {
		return environment;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	
	
}
