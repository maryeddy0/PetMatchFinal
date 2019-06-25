package com.petmatch.PetMatch.pojosDB;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String userid;
	private String viewHistory;
	
	public User(String userid, String viewHistory) {
		super();
		this.userid = userid;
		this.viewHistory = viewHistory;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getViewHistory() {
		return viewHistory;
	}

	public void setViewHistory(String viewHistory) {
		this.viewHistory = viewHistory;
	}
	
	
}
