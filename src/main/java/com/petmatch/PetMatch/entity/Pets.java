package com.petmatch.PetMatch.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pets {

	private List<Animals> animal;
	private Pagination pagination;

	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Pets(List<Animals> animal, Pagination pagination) {
		super();
		this.animal = animal;
		this.pagination = pagination;
	}




	public List<Animals> getAnimal() {
		return animal;
	}

	public void setAnimal(List<Animals> animal) {
		this.animal = animal;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}




	@Override
	public String toString() {
		return "Pets [animal=" + animal + ", pagination=" + pagination + "]";
	}



}
