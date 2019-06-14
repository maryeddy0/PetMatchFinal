package com.petmatch.PetMatch.entity;

public class Animals {
	
	private Integer id;
	private String type;
	private String species;
	private String breed;
	private String environment;
	
	public Animals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Animals(Integer id, String type, String species, String breed, String environment) {
		super();
		this.id = id;
		this.type = type;
		this.species = species;
		this.breed = breed;
		this.environment = environment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "Animals [id=" + id + ", type=" + type + ", species=" + species + ", breed=" + breed + ", environment="
				+ environment + "]";
	}
	
	
	
	
	
	

}
