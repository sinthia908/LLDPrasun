package com.interview;

import java.util.*;

public class InventoryManagment {
	
	private  final Product product;
    public Product getProduct() {
		return product;
	}


	public int getQuantity() {
		return quantity;
	}


	private  final int quantity;
    
    
    public InventoryManagment(Product product,int quantity) {
    	this.product = product;
    	this.quantity = quantity;
    	
    }
    
    
 
	}
	