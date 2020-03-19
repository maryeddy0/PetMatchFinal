package com.petmatch.PetMatch.pojosDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userid;
	private String email;
	
	@OneToMany
	private List<History> history = new ArrayList<>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public User(String email) {
	super();
	this.email = email;
}


	public User(Integer userid, String email) {
		super();
		this.userid = userid;
		this.email = email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}


	public List<History> getHistory() {
		return history;
	}


	public void setHistory(List<History> history) {
		this.history = history;
	}


	public String getEmail() {
		return email;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", email=" + email + "]";
	}
	
	
}
