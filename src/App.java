import java.time.LocalDate;

// Main Application Class
public class App {
    public static void main(String[] args) {
        // --- 1. Adding products to the store ---
        Product cheese = new PerishableProduct("cheese", 100, 10, 0.2, LocalDate.now().plusDays(30)); // 200g
        Product biscuits = new PerishableProduct("biscuits", 150, 15, 0.7, LocalDate.now().plusDays(60)); // 700g
        Product tv = new ElectronicsProduct("TV", 5000, 5, 8.0); // 8kg
        Product scratchCard = new DigitalProduct("scratch card", 50, 100);
        Product expiredCheese = new PerishableProduct("old cheese", 80, 5, 0.2, LocalDate.now().minusDays(1));


        // --- 2. setting the services and customer ---
        ShippingService shippingService = new ShippingService();
        CheckoutService checkoutService = new CheckoutService(shippingService);
        Customer customer = new Customer("Youssef Mohamed", 10000);
        Cart cart = new Cart();

        System.out.println("===== demo 1 Expected Output: {successful checkout} =====");
        try {
            cart.addProduct(cheese, 2); 
            cart.addProduct(biscuits, 1); 
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        cart.clear(); 
        System.out.println("\n========================================================\n");


        System.out.println("===== demo 2 Expected Output: {cart with non-shippable and shippable items} =====");
        System.out.printf("Initial TV stock: %d%n", tv.getQuantity());
        try {
            cart.addProduct(tv, 1);
            cart.addProduct(scratchCard, 3);
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.printf("Final TV stock: %d%n", tv.getQuantity());
        cart.clear();
        System.out.println("\n========================================================\n");


        System.out.println("===== demo 3 Expected Output: {ERROR - insufficient balance} =====");
        try {
            cart.addProduct(tv, 1); // TV costs 5000, shipping is 80. Total 5080.  Customer balance is less than 5080 after previous purchases.
            System.out.printf("customer balance before trying: %.2f%n", customer.getBalance());
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        cart.clear();
        System.out.println("\n========================================================\n");
        

        System.out.println("===== demo 4 Expected Output: {ERROR - out of stock} =====");
        try {
            System.out.printf("available cheese: %d%n", cheese.getQuantity());
            cart.addProduct(cheese, 99);            // We only have  4 left
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        cart.clear();
        System.out.println("\n========================================================\n");


        System.out.println("===== demo 5 Expected Output: {ERROR - expired item} =====");
        try {
            cart.addProduct(expiredCheese, 1);
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        cart.clear();
        System.out.println("\n========================================================\n");


        System.out.println("===== demo 6 Expected Output: {ERROR - empty cart} =====");
        try {
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        cart.clear();
        System.out.println("\n========================================================");
    }
} 