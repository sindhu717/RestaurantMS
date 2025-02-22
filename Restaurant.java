public class Restaurant {
    private final Menu menu;

    public Restaurant() {
        menu = new Menu();
    }

    public void addMenuItem(Item item) {
        menu.addItem(item);
    }

    public Menu getMenu() {
        return menu;
    }

    public void processOrder(Order order) {
        order.printOrderDetails();
    }
}
