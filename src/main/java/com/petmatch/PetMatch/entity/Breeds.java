package com.petmatch.PetMatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Breeds {
	private String primary;
	private boolean mixed;
	

	public Breeds() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Breeds(String primary, boolean mixed) {
		super();
		this.primary = primary;
		this.mixed = mixed;
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
	public boolean isMixed() {
		return mixed;
	}
	public void setMixed(boolean mixed) {
		this.mixed = mixed;
	}
	@Override
	public String toString() {
		return "Breeds [primary=" + primary + ", mixed=" + mixed + "]";
	}
	
	
	
}
