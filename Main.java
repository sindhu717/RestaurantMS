import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Restaurant restaurant = new Restaurant();
            restaurant.addMenuItem(new Dish("Pasta", 12.99));
            restaurant.addMenuItem(new Dish("Pizza", 15.99));
            restaurant.addMenuItem(new Drink("Coke", 3.99));
            restaurant.addMenuItem(new Drink("Coffee", 4.99));
            restaurant.addMenuItem(new Drink("Badam Milk", 3.99));

            System.out.println("Welcome to the Restaurant Management System!");

            boolean continueOrdering = true;
            Order order = new Order();

            while (continueOrdering) {
                System.out.println("\nMenu:");
                for (Item item : restaurant.getMenu().getItems()) {
                    item.printItemDetails();
                }

                System.out.print("Enter the name of the item you want to order: ");
                String itemName = scanner.nextLine();

                try {
                    order.addItem(restaurant.getMenu().getItemByName(itemName));
                } catch (InvalidOrderException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                System.out.print("Do you want to add more items? (yes/no): ");
                String response = scanner.nextLine();
                continueOrdering = response.equalsIgnoreCase("yes");
            }

            OrderProcessor orderProcessor = new OrderProcessor(restaurant, order);
            orderProcessor.start();

            try {
                orderProcessor.join();
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
