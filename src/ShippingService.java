import java.util.List;

public class ShippingService {
    public void processShipment(List<ShippableItem> itemsToShip) {
        if (itemsToShip.isEmpty()) {
            return;
        }
        System.out.println("\n** Shipment notice **");
        double totalWeight = 0;
        for (ShippableItem item : itemsToShip) {
            System.out.printf("%dx %-15s %.0fg%n", item.getQuantity(), item.getName(), item.getTotalWeight() * 1000);
            totalWeight += item.getTotalWeight();
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
} 