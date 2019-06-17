package com.petmatch.PetMatch.entity.types;

import java.sql.Types;
import java.util.ArrayList;

public class AminalTypes {

	private ArrayList<Types> types;

	public AminalTypes(ArrayList<Types> types) {
		super();
		this.types = types;
	}

	public AminalTypes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Types> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<Types> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "AminalTypes [types=" + types + "]";
	}
	
	
	
}
