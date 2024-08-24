package com.interview;

import java.util.List;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private List<Order> orders;
	
	public User(int id,String name,String email,String password) {
		  this.id = id;
		  this.name = name;
		  this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
	    orders.add(order);
	}
	
}
