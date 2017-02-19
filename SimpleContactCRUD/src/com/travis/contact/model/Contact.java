package com.travis.contact.model;

import java.io.Serializable;

public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;
	private int contactId;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getContactId() {
		return contactId;
	}
	
	public void setContactId(int id) {
		this.contactId = id;
	}
	
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", address=" + address + "]";
	}	
}
