package com.petmatch.PetMatch.entity.types;

public class Types {

	private String name;
	
	
	public Types(String name) {
		super();
		this.name = name;
	}

	public Types() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Types [name=" + name + "]";
	}

	
	
}
