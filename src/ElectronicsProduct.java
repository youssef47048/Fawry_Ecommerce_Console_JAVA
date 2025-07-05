public class ElectronicsProduct extends Product implements Shippable {
    private final double weight;

    public ElectronicsProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() { return weight; }
} 