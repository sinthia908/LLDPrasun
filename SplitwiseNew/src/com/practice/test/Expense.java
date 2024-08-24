package com.practice.test;

import java.util.*;
import java.io.*;

public class Expense {
	private int id;
	private double amount;
	private String description;
	private User paidBy;
	private List<Split> splits;
	
	
	Expense(int id,double amount,String description,User paidBy){
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.paidBy = paidBy;
		this.splits = new ArrayList<>();
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getPaidBy() {
		return paidBy;
	}


	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}


	public List<Split> getSplits() {
		return splits;
	}


	public void setSplits(List<Split> splits) {
		this.splits = splits;
	}


	

}
