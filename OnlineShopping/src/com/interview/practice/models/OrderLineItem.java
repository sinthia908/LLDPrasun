package com.interview.practice.models;

public class OrderLineItem {
    public String getProductId() {
        return productId;
    }

    private final String productId;

    public String getProductName() {
        return productName;
    }

    private final String productName;

    public int getQuantity() {
        return quantity;
    }

    private final int quantity;

    public double getPriceAtPurchase() {
        return priceAtPurchase;
    }

    private final double priceAtPurchase;


    public OrderLineItem(String productId,String productName,int quantity,double priceAtPurchase){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
    }


}
