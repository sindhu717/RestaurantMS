public class Drink extends Item {
    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public void printItemDetails() {
        System.out.println("Drink: " + getName() + ", Price: $" + getPrice());
    }
}
