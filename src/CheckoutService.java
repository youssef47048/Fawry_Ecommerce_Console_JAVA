import java.util.*;

public class CheckoutService {
    private final ShippingService shippingService;
    private static final double fees = 10.0;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.getItems().isEmpty()) {
            throw new Exception("Checkout Error: Cart is empty.");
        }
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            if (quantity > product.getQuantity()) {
                throw new Exception("Checkout Error: Product " + product.getName() + " is out of stock.");
            }
            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                throw new Exception("Checkout Error: Product " + product.getName() + " is expired.");
            }
        }
        
        double subtotal = 0;
        double totalWeight = 0;
        List<ShippableItem> shippableItems = new ArrayList<>();
        List<Map.Entry<Product, Integer>> receiptItems = new ArrayList<>(cart.getItems().entrySet());

        for (Map.Entry<Product, Integer> entry : receiptItems) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            subtotal += product.getPrice() * quantity;
            if (product instanceof Shippable) {
                shippableItems.add(new ShippableItem(product, quantity));
                totalWeight += ((Shippable) product).getWeight() * quantity;
            }
        }

        double shippingFee = totalWeight * fees;
        double totalAmount = subtotal + shippingFee;

        if (customer.getBalance() < totalAmount) {
            throw new Exception("Checkout Error: Insufficient customer balance.");
        }

        customer.cutBalance(totalAmount);
        for (Map.Entry<Product, Integer> entry : receiptItems) {
            entry.getKey().reduceQuantity(entry.getValue());
        }

        shippingService.processShipment(shippableItems);

        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : receiptItems) {
            Product p = entry.getKey();
            int q = entry.getValue();
            System.out.printf("%dx %-15s %.0f%n", q, p.getName(), p.getPrice() * q);
        }
        System.out.println("------------------------");
        System.out.printf("%-15s %.0f%n", "Subtotal", subtotal);
        System.out.printf("%-15s %.0f%n", "Shipping", shippingFee);
        System.out.printf("%-15s %.0f%n", "Amount", totalAmount);
        System.out.println("------------------------");
        System.out.printf("Payment successful. %s's new balance is %.2f.%n", customer.getName(), customer.getBalance());
    }
} 