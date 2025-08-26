package com.interview.practice.services;

import com.interview.practice.models.Customer;
import com.interview.practice.models.Order;
import com.interview.practice.models.OrderLineItem;
import com.interview.practice.models.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final InventoryService inventoryService;

    public OrderService(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    public Order createOrder(Customer customer, ShoppingCart shoppingCart){
        List<OrderLineItem> result = new ArrayList<>();

        shoppingCart.getItems().values().stream()
                .map(cartItem -> new OrderLineItem(cartItem.getProduct().getId(),
                        cartItem.getProduct().getName(),
                        cartItem.getQuantity(),
                        cartItem.getProduct().getPrice()))
                       .forEach(result::add);

        inventoryService.updateStockForOrder(result);

        return new Order(customer,result,customer.getShippingAddress(),shoppingCart.calculateTotal());





    }
}

