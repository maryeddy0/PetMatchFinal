package com.petmatch.PetMatch.entities;
// Stassi
public class Organization {
	
	private Integer id;
	private String name;
	private String phone;
	private String address;
	
	public Organization() {
		super();
		// TODO Auto-gengit erated constructor stub
	}

	public Organization(Integer id, String name, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Organizations [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}

		
	

}
