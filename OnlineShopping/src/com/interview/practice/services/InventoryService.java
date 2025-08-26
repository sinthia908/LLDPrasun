package com.interview.practice.services;

import com.interview.practice.models.OrderLineItem;
import com.interview.practice.models.Product;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {
    // productId -> quantity

    private final Map<String,Integer> stock; // productId -> quantity

    public InventoryService(){
           stock = new ConcurrentHashMap<>();
    }
    public void addStock(Product product,int quantity){
            stock.put(product.getId(),stock.getOrDefault(product.getId(),0)+1);
    }

    public synchronized void updateStockForOrder(List<OrderLineItem> lineItems){

     // First , check if all line items are in stock

     for(OrderLineItem item : lineItems){
         if ( stock.getOrDefault(item.getProductId(),0)< item.getQuantity()){
             //throw new OutOfStockException("Not enough stock for product ID: " + item.getProductId());
         }
     }

     // if all stocks pass , deduct the stock

        for(OrderLineItem lineItem : lineItems){
            stock.compute(lineItem.getProductId(), (id,currentStock)-> currentStock- lineItem.getQuantity());
        }

    }

}
