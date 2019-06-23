//Get Animal Endpoint >Pets>Animals

package com.petmatch.PetMatch.entities;
/*API endpoint:  GET https://api.petfinder.com/v2/animals*/


import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pets {

	private ArrayList<Animals> animals;

	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Animals> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animals> animals) {
		this.animals = animals;
	}
	
	




//	@Override
//	public String toString() {
//		return "Pets [animal=" + animals + ", pagination=" + pagination + "]";
//	}



}
