package com.interview;

import java.util.*;

public class Order {

	private int id;
    private Customer customer;
	private Restuarant restuarant;
	private List<OrderItem> orderItems;
	private OrderStatus orderstatus;
	
	
	public Order(int id,Customer customer,Restuarant restuarant) {
		this.id = id;
		this.customer = customer;
		this.restuarant = restuarant;
		this.orderItems = new ArrayList<>();
		this.orderstatus = OrderStatus.PENDING;
		
	}
	
	 public void addItem(OrderItem item) {
	        orderItems.add(item);
	    }

	    public void removeItem(OrderItem item) {
	        orderItems.remove(item);
	    }
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Restuarant getRestuarant() {
		return restuarant;
	}


	public void setRestuarant(Restuarant restuarant) {
		this.restuarant = restuarant;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


	public OrderStatus getOrderstatus() {
		return orderstatus;
	}


	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}
	
}
