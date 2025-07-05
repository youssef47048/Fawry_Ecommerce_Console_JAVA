import java.time.LocalDate;

public class PerishableProduct extends Product implements Shippable, Expirable {
    private final double weight;
    private final LocalDate expiryDate;

    public PerishableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public double getWeight() { return weight; }

    @Override
    public boolean isExpired() { return LocalDate.now().isAfter(expiryDate); }
    
    @Override
    public LocalDate getExpiryDate() { return expiryDate; }
} 