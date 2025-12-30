package com.interview.practice;

import com.interview.practice.models.*;
import com.interview.practice.services.InventoryService;
import com.interview.practice.services.OrderService;
import com.interview.practice.services.PaymentService;
import com.interview.practice.services.SearchService;
import com.interview.practice.statergy.PaymentStatergy;

import java.util.List;
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

    public void addProduct(Product product,int initialStock){
        products.put(product.getId(),product);
        inventoryService.addStock(product,initialStock);

    }

    public Customer registerCustomer(String name, String email, String password,Address address){
        Customer customer = new Customer(name,email,password,address);
        customers.put(customer.getId(),customer);
        return customer;
    }

    public void addToCart(String customerId,String productId,int quantity){
        Customer customer = customers.get(customerId);
        Product product = products.get(productId);
        customer.getAccount().getCart().addItem(product,quantity);
    }


    public List<Product> searchProdcuts(String name){
        return searchService.searchByName(name);
    }

    public ShoppingCart getCustomerCart(String customerId) {
        Customer customer = customers.get(customerId);
        return customer.getAccount().getCart();
    }

    public Order placeOrder(String customerId, PaymentStatergy paymentStatergy){
        Customer customer = customers.get(customerId);
        ShoppingCart cart = customer.getAccount().getCart();
        if (cart.getItems().isEmpty()){
            System.out.print("Cannot place an order with an empty cart.");
            return null;
        }

        // 1.Process Payment

        boolean paymentSuccess = paymentService.processPayment(paymentStatergy,cart.calculateTotal());

        if (!paymentSuccess){
            System.out.println("Payment failed.");
            return null;
        }
        // 2.Create order and update inventory

        try{
            Order order = orderService.createOrder(customer,cart);
            orders.put(order.getId(),order);

            // 3.Clear the cart

            cart.clearCart();
            return order;

        }catch(Exception ex){
            System.err.println("Order Place failed");
            // In a real system, we would trigger a refund here.
            return null;
        }
    }
}
