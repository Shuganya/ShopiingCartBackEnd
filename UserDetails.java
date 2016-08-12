package com.niit.shoppingcart.model;

import javax.persistence.*;


import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class UserDetails {
	@Id
	private String id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String conpass;
	private String contact;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConpass() {
		return conpass;
	}
	public void setConpass(String conpass) {
		this.conpass = conpass;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	

}
