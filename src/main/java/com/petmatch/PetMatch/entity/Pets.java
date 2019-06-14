package com.petmatch.PetMatch.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pets {

	private List<Animals> animal;
	private Pagination pagenation;

	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pets(List<Animals> animal) {
		super();
		this.animal = animal;
	}

	public Pets(Pagination pagenation) {
		super();
		this.pagenation = pagenation;
	}

	public List<Animals> getAnimal() {
		return animal;
	}

	public void setAnimal(List<Animals> animal) {
		this.animal = animal;
	}
	
	public Pagination getPagenation() {
		return pagenation;
	}

	public void setPagenation(Pagination pagenation) {
		this.pagenation = pagenation;
	}

	@Override
	public String toString() {
		return "Pets [animal=" + animal + ", pagenation=" + pagenation + "]";
	}

	

}
