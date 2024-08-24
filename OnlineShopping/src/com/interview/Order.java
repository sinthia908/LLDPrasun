package com.interview;

import java.util.List;

public class Order {
	private int id;
	private User user;
	private List<OrderItem> orderItem;
    private OrderStatus orderStatus;
    private Double totalAmount;
    
    Order(int id,User user,List<OrderItem> orderItem){
    	this.id = id;
    	this.user = user;
    	this.orderItem = orderItem;
    	this.orderStatus = OrderStatus.PENDING;  	
    	this.totalAmount = totalAmount;
    }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
