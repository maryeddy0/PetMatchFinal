package com.petmatch.PetMatch.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Popularpets {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String age;
	private String gender;
	private String image;
	
	
	
	public Popularpets() {
		super();

	}



	public Popularpets(Integer id, String name, String age, String gender, String image) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.image = image;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "Popularpets [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", image=" + image
				+ "]";
	}


}
