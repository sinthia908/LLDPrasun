package com.practice.test;

public abstract class Split {
	protected User user;
	protected double amount;
	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	Split(User user){
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	// Abstract method
	public abstract double getAmount();
	
	

}
