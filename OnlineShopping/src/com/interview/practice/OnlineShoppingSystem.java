package com.interview.practice;

import com.interview.practice.models.Customer;
import com.interview.practice.models.Order;
import com.interview.practice.models.Product;
import com.interview.practice.services.InventoryService;
import com.interview.practice.services.OrderService;
import com.interview.practice.services.PaymentService;
import com.interview.practice.services.SearchService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineShoppingSystem {

    // Data Stores
    private static OnlineShoppingSystem instance;
    private final Map<String, Product> products;
    private final Map<String, Customer> customers;
    private final Map<String, Order> orders;

    // Services

    private final InventoryService inventoryService;
    private final OrderService orderService;
    private final PaymentService paymentService;
    private final SearchService searchService;


    private OnlineShoppingSystem(){
            products = new ConcurrentHashMap<>();
            customers = new ConcurrentHashMap<>();
            orders = new ConcurrentHashMap<>();
            inventoryService = new InventoryService();
            orderService = new OrderService(inventoryService);
            paymentService = new PaymentService();
            searchService = new SearchService(products.values());
    }


    public static OnlineShoppingSystem getInstance() {
        if (instance == null)
            synchronized (OnlineShoppingSystem.class) {
                if (instance == null) {
                    instance = new OnlineShoppingSystem();
                    return instance;
                }
            }
        return instance;
    }


    //  Facade methods for simplified interaction

    public void addProducts(Product product,int initialStock){

        products.put(product.getId(),product);
        inventoryService.addStock(product,initialStock);


    }



}
