package com.example.entity;

import java.sql.Date;

public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private Long addressID;
	
	public Employee(Long id, String firstName, String lastName, Date birthday, Long addressID) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.addressID = addressID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Long getAddressID() {
		return addressID;
	}
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}
	
}
