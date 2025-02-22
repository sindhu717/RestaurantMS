public class OrderProcessor extends Thread {
    private final Order order;
    private final Restaurant restaurant;

    public OrderProcessor(Restaurant restaurant, Order order) {
        this.restaurant = restaurant;
        this.order = order;
    }

    @Override
    public void run() {
        try {
            restaurant.processOrder(order);
        } catch (Exception e) {
            System.out.println("Error processing order: " + e.getMessage());
        }
    }
}
