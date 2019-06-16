package com.petmatch.PetMatch.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Breeds {
	private String primary;
	private String mixed;
	
	public Breeds() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
	public String getMixed() {
		return mixed;
	}
	public void setMixed(String mixed) {
		this.mixed = mixed;
	}
	
	
}
