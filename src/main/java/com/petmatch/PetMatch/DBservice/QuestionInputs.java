package com.petmatch.PetMatch.DBservice;


//Originally created to store user input as an object. then changed mind
//potentially can be used in the future to store user input into DB 
public class QuestionInputs {
	private String space;
	private String interact;
	private String cost;
	private String hours;
	private String noise;
	
	public QuestionInputs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionInputs(String space, String interact, String cost, String hours, String noise) {
		super();
		this.space = space;
		this.interact = interact;
		this.cost = cost;
		this.hours = hours;
		this.noise = noise;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getInteract() {
		return interact;
	}
	public void setInteract(String interact) {
		this.interact = interact;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getNoise() {
		return noise;
	}
	public void setNoise(String noise) {
		this.noise = noise;
	}
	
	
	
}
