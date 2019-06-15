package com.petmatch.PetMatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Animals {
	
	private Integer id;
	private String type;
	private String species;
	private Breeds breeds;
	private Environment environment;
	private String url;
	
	public Animals() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Animals(Integer id, String type, String species, Breeds breeds, Environment environment, String url) {
		super();
		this.id = id;
		this.type = type;
		this.species = species;
		this.breeds = breeds;
		this.environment = environment;
		this.url = url;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
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


	public Breeds getBreeds() {
		return breeds;
	}


	public void setBreeds(Breeds breeds) {
		this.breeds = breeds;
	}


	public Environment getEnvironment() {
		return environment;
	}


	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}


	@Override
	public String toString() {
		return "Animals [id=" + id + ", type=" + type + ", species=" + species + ", breeds=" + breeds + "]";
	}


	
	
	

}
