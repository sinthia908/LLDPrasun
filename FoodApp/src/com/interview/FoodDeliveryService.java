package com.interview;

import java.util.*;

public class FoodDeliveryService {
	
	private static FoodDeliveryService instance;
	private Map<Integer,Customer> customers;
	private Map<Integer,Restuarant> restuarants;
	private Map<Integer,Order> orders;
	private Map<Integer,DeliveryAgent> deliveryAgent ;
	
	
	FoodDeliveryService(){
	customers = new HashMap<>();
	restuarant = new HashMap<>();
	orders = new HashMap<>();
	deliveryAgent = new HashMap<>();
	
	
	}
	
	public static synchronized FoodDeliveryService getInstance() {
		if (instance == null)
			instance = new FoodDeliveryService();
		return instance;
	}
	
	// Function to registrar a customer 
	public void registerCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}
	
	// Function to register a restuanrant
	
	public void registerResturant(Restuarant restuarant) {
		restuarant.put(restuarant,restuarant);
	}
	
	// Function to place a order 
	

	public Order placeOrder(int customerid,int resturantid,List<OrderItem> items) {
		
		Customer customer = customers.get(customerid);
		Restuarant restuarant = restuarants.get(resturantid);
		
		if ( customer != null && restuarant != null) {
			Order order = new Order(11122,customer,restuarant);
			for(OrderItem item : items)
				order.addItem(item);
			orders.put(order.getId(), order);
			notifyRestuarant(order);
			System.out.println("Order placed: " + order.getId());
			return order;
		}
		
		return null;
	}
	
private void notifyRestuarant(Order order) {
		// TODO Auto-generated method stub
		
	}

	// 
	public void updateOrderStatus(int orderId,OrderStatus orderStatus) {
	 Order order = orders.get(orderId);
	 if (order != null) {
		 order.setOrderstatus(orderStatus);
		 notifyCustomer(order);
		 if (orderStatus == OrderStatus.CONFIRMED) {
             assignDeliveryAgent(order);
         }
	   }
	}

	private void notifyCustomer(Order order) {
		// TODO Auto-generated method stub
		
	}
	
	//
	
	//
	
	
	

}
