import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Order {
    private CartItem[] items;
    private double totalAmount;
    private String orderDate;
    private int itemCount;

    public Order(Cart cart) {
        this.itemCount = cart.getItemCount();
        this.items = new CartItem[itemCount];


        for (int i = 0; i < itemCount; i++) {
            CartItem cartItem = cart.getItem(i);
            this.items[i] = new CartItem(cartItem.getPart(), cartItem.getQuantity());
        }

        this.totalAmount = cart.getTotal();


        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.orderDate = now.format(formatter);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void displayOrderSummary() {
        System.out.println("\n========== ORDER SUMMARY ==========");
        System.out.println("Order Date: " + orderDate);
        System.out.println("-----------------------------------");

        for (int i = 0; i < itemCount; i++) {
            items[i].display();
        }

        System.out.println("-----------------------------------");
        System.out.printf("Total Amount: $%.2f%n", totalAmount);
        System.out.println("===================================");
    }

    public boolean processPayment() {

        for (int i = 0; i < itemCount; i++) {
            CarPart part = items[i].getPart();
            int quantity = items[i].getQuantity();
            part.reduceStock(quantity);
        }
        return true;
    }

    public CartItem[] getItems() {
        return items;
    }
}
