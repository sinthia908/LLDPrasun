package com.interview.practice;

import com.interview.practice.enums.ProductCategory;
import com.interview.practice.models.*;

public class OnlineShoppingDemo {
    public static void main(String[] args){

        // --- System Setup (Singleton and Services) ---

    OnlineShoppingSystem onlineShoppingSystem = OnlineShoppingSystem.getInstance();

        // --- Create and Add Products to Catalog (Builder Pattern) ---
        Product laptop = new Product.Builder("Dell XPS 15", 1499.99)
                .withDescription("A powerful and sleek laptop.")
                .withCategory(ProductCategory.ELECTRONICS)
                .build();

        Product book = new Product.Builder("The Pagrammatic Programmer",45.60)
                .withDescription("A classic book for software developers.")
                .withCategory(ProductCategory.BOOKS)
                .build();

        onlineShoppingSystem.addProduct(laptop,10);  // 10 laptops in stock
        onlineShoppingSystem.addProduct(book,5);  // 50 books in stock

       // Register a customer
     //   Account account = new Account("Prasun","");
        Address address = new Address("Dr.B.Baruah Road","Guwahati","Karnataka","781007");

        Customer prasun  = onlineShoppingSystem.registerCustomer("Prasun","prasunmazumder@gmail.com","12345",address);

        // Prasun starts shopping...

        // Alice adds a laptop to her cart

        onlineShoppingSystem.addToCart(prasun.getId(), laptop.getId(), 1);

        System.out.println("Alice added a laptop to the cart");

        ShoppingCart prasunCart = onlineShoppingSystem.getCustomerCart(prasun.getId());

        System.out.printf("Prasun's cart total: $%.2f%n", prasunCart.calculateTotal());

        // --- Alice Checks Out ---
        System.out.println("\n--- Alice proceeds to checkout ---");

        

    }


}
