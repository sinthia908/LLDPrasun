package com.interview;

public class Product {
	private final int id;
	private final String name;
	private final String description;
	private final double price;
	private int quantity;
	
	public Product(int id,String name,String description,double price,int quantity) {
		  this.id = id;
		  this.name = name;
		  this.description = description;
		  this.price = price;
		  this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
	
}
