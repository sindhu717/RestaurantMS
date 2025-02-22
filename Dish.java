public class Dish extends Item {
    public Dish(String name, double price) {
        super(name, price);
    }

    @Override
    public void printItemDetails() {
        System.out.println("Dish: " + getName() + ", Price: $" + getPrice());
    }
}
