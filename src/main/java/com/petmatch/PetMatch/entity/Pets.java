package com.petmatch.PetMatch.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pets {

	private ArrayList<Animals> animals;
	private Pagination pagination;

	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Pets(ArrayList<Animals> animals, Pagination pagination) {
		super();
		this.animals = animals;
		this.pagination = pagination;
	}




	public ArrayList<Animals> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animals> animals) {
		this.animals = animals;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}




//	@Override
//	public String toString() {
//		return "Pets [animal=" + animals + ", pagination=" + pagination + "]";
//	}



}
