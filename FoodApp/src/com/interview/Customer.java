package com.interview;

public class Customer {

	private int id;
	private String name;
    private String emailId;
	private String address;
	
    public Customer(int id,String name,String emailId,String address) {
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.address = address;
	}
    
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


}
