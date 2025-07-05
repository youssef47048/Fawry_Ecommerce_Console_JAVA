public class ShippableItem {
    private final String name;
    private final double totalWeight;
    private final int quantity;

    public ShippableItem(Product product, int quantity) {
        if (!(product instanceof Shippable)) {
            throw new IllegalArgumentException("Product must be shippable.");
        }
        this.name = product.getName();
        this.quantity = quantity;
        this.totalWeight = ((Shippable) product).getWeight() * quantity;
    }

    public String getName() { return name; }
    public double getTotalWeight() { return totalWeight; }
    public int getQuantity() { return quantity; }
} 