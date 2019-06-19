package com.petmatch.PetMatch.entities;
// Stassi
public class Organization {
	
	private String id;
	private String name;
	private String phone;
	private Address address;
	
	public Organization() {
		super();
		// TODO Auto-gengit erated constructor stub
	}

	public Organization(String id, String name, String phone, Address address) {

		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {

		return "Organizations [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}

		
	

}
