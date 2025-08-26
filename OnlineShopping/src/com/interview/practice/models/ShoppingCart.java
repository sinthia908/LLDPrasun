package com.interview.practice.models;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<String, cartItem> items = new HashMap<>();

    public void addItem(Product product,int quantity){
        if ( items.containsKey(product.getId())){
            items.get(product.getId()).incrementQuantity(quantity);
        }
        else items.put(product.getId(),new cartItem(product,quantity));
    }

    public void removeItem(String productId){
           items.remove(productId);
    }
    public Map<String, cartItem> getItems() {
        return Collections.unmodifiableMap(new HashMap<>(items));
    }

    public double calculateTotal(){
            return items.values().stream().mapToDouble(cartItem::getPrice).sum();
    }

    public void clearCart(){
        items.clear();
    }
}