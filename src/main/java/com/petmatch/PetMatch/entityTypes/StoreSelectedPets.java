package com.petmatch.PetMatch.entityTypes;

//create this class to hold the basic information as an object in order to display on the page.
public class StoreSelectedPets {
	private String photos;
	private String name;
	private String age;
	private String gender;
	private String description;
	private String organizationID;
	
	
	public StoreSelectedPets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StoreSelectedPets(String photo, String name, String description) {
		super();
		this.photos = photo;
		this.name = name;
		this.description = description;
	}

	public StoreSelectedPets(String photos, String name, String age, String gender, String description,
			String organizationID) {
		super();
		this.photos = photos;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.description = description;
		this.organizationID = organizationID;
	}

	public StoreSelectedPets(String photos) {
		super();
		this.photos = photos;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	public String getOrganizationID() {
		return organizationID;
	}

	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}