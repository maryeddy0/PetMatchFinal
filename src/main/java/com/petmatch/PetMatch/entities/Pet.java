package com.petmatch.PetMatch.entities;

/*API endpoint:  GET https://api.petfinder.com/v2/animals/{id}*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {
	private Animal animal;

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
}
