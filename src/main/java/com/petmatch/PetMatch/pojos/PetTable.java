package com.petmatch.PetMatch.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pets")
public class PetTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer petid;
	private String petType;
	private String keywords;
	
	public PetTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetTable(String keywords) {
		super();
		this.keywords = keywords;
	}

	public PetTable(String petType, String keywords) {
		super();
		this.petType = petType;
		this.keywords = keywords;
	}

	public PetTable(Integer petid, String petType, String keywords) {
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
		return petid + "," + petType + "," + keywords;
	}
	
}
