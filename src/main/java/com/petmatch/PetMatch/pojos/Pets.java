package com.petmatch.PetMatch.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pets {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer petid;
	private String petType;
	private String keywords;
	
	
	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pets(Integer petid, String petType, String keywords) {
		super();
		this.petid = petid;
		this.petType = petType;
		this.keywords = keywords;
	}
	public Integer getPetid() {
		return petid;
	}
	public void setPetid(Integer petid) {
		this.petid = petid;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	@Override
	public String toString() {
		return "Pets [petid=" + petid + ", petType=" + petType + ", keywords=" + keywords + "]";
	}
	

	
	
	
}
