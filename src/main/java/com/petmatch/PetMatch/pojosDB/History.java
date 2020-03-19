package com.petmatch.PetMatch.pojosDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@Entity // to map this class to DB table use Entity annotation provided by JPA
public class History {
	@Id //reperents primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //becoz the value of id is AI
	private Integer id;
	private Integer userid;
	@Column(name = "petid")
	private Integer petID;
	private String photo;
	private String petName;
	private String contactEmail;
	private String contactPhone;
	private String organizationName;

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public History(String photo, String petName, String contactEmail, String contactPhone, String organizationName) {
		super();
		this.photo = photo;
		this.petName = petName;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.organizationName = organizationName;
	}


	public History(Integer userid, Integer petID, String photo, String petName, String contactEmail,
			String contactPhone, String organizationName) {
		super();
		this.userid = userid;
		this.petID = petID;
		this.photo = photo;
		this.petName = petName;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.organizationName = organizationName;

	}
	
	

	public History(Integer id, Integer userid, Integer petID, String photo, String petName, String contactEmail,
			String contactPhone, String organizationName) {
		super();
		this.id = id;
		this.userid = userid;
		this.petID = petID;
		this.photo = photo;
		this.petName = petName;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.organizationName = organizationName;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

//	public User getUser() {
//		return user;
//	}
//
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPetID() {
		return petID;
	}

	public void setPetID(Integer petID) {
		this.petID = petID;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", userid=" + userid + ", petID=" + petID + ", photo=" + photo + ", petName="
				+ petName + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone + ", organizationName="
				+ organizationName + "]";
	}
	
	
}
