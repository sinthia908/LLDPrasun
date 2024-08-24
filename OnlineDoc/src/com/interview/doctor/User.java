package com.interview.doctor;

public abstract class User {
	private int id;
	private String name;
	private String email;
	private int mobileNumber;
	
	User(int id,String name,String email,int mobileNumber){
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
   
    

}
