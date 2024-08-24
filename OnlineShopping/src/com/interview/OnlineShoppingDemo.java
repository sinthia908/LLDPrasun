package com.interview;

public class OnlineShoppingDemo {
	
	public static void run() {
	OnlineShoppingService onlineShoppingService = OnlineShoppingService.getInstance();
	
	// RegisterUsers
	
	User user1 = new User(123,"Prasun","prasunmazumder@gmail.com","123");
	User user2 =  new User(123,"Sinthia","prasunmazumder@gmail.com","123");
	
	onlineShoppingService.registerUser(user1);
	onlineShoppingService.registerUser(user2);
	
	// Add products
	
    Product product1 = new Product(3445, "Smartphone", "High-end smartphone", 999.99, 10);
    Product product2 = new Product(89992, "Laptop", "Powerful gaming laptop", 1999.99, 5);
    onlineShoppingService.addProduct(product1);
    onlineShoppingService.addProduct(product2);
    
   
    onlineShoppingService.addProductsToInventory(product1, 10);
    onlineShoppingService.addProductsToInventory(product2, 10);
    
    
    // User 1 adds products to cart and places an order
    ShoppingCart cart1 = new ShoppingCart();
   
  //   if ( )
    cart1.addItem(product1, 2);
    cart1.addItem(product2, 1);
    Payment payment1 = new CreditCardPayment();
    Order order1 = onlineShoppingService.placeOrder(user1, cart1, payment1);
    System.out.println("Order placed: " + order1.getId());

    // User 2 searches for products and adds to cart
    List<Product> searchResults = shoppingService.searchProducts("laptop");
    System.out.println("Search Results:");
    for (Product product : searchResults) {
        System.out.println(product.getName());
    }

    ShoppingCart cart2 = new ShoppingCart();
    cart2.addItem(searchResults.get(0), 1);
    Payment payment2 = new CreditCard();
    Order order2 = shoppingService.placeOrder(user2, cart2, payment2);
    System.out.println("Order placed: " + order2.getId());

    // User 1 views order history
    List<Order> userOrders = user1.getOrders();
    System.out.println("User 1 Order History:");
    for (Order order : userOrders) {
        System.out.println("Order ID: " + order.getId());
        System.out.println("Total Amount: $" + order.getTotalAmount());
        System.out.println("Status: " + order.getStatus());
    }
}
    
    
	 private String generateOrderId() {
	        return "ORDER" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	
	}
}
