import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Item> items;
    private double total;

    public Order() {
        items = new ArrayList<>();
        total = 0.0;
    }

    public void addItem(Item item) throws InvalidOrderException {
        if (item == null) {
            throw new InvalidOrderException("Item not found in the menu");
        }
        items.add(item);
        total += item.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public void printOrderDetails() {
        System.out.println("Order Details:");
        for (Item item : items) {
            item.printItemDetails();
        }
        System.out.println("Total: $" + total);
    }
}
