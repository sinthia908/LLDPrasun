package com.interview;

import java.util.*;

public class ShoppingCart {
	private final Map<Integer, OrderItem> items;
// 	private final InventoryManagment inv = new InventoryManagment();
    
	
	public ShoppingCart() {
		this.items = new HashMap<>();
	}
	
	// Add item to the Shopping Cart
	public void addItem(Product product,Integer quantity) {
		//checkAvailability(product) is available in the inventory before adding to the cart
		
	//if (inv.isProductAvailable(product)) {
		int productId = product.getId();
		
		if (items.containsKey(productId)) {
			OrderItem item = items.get(productId);
			quantity += item.getQuantity();
		
		   }
		
		items.put(productId,new OrderItem(product,quantity));
		}
	
	// Remove Item from the Shopping Cart 
	
	public void removeItem(int productId) {
		items.remove(productId);	
	} 
	
	// Function to get list of all items
	
	 public List<OrderItem> getItems() {
	        return new ArrayList<>(items.values());
	    }

	    public void clear() {
	        items.clear();
	    }

}
