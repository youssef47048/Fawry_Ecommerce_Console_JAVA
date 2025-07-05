import java.util.*;

public class Cart {
    private final Map<Product, Integer> items = new LinkedHashMap<>();

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Warning: Quantity must be positive. Did not add " + product.getName() + ".");
            return;
        }
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Product, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }
    
    public void clear() {
        items.clear();
    }
} 