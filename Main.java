import java.util.Scanner;

class CarPartsShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShopManager shopManager = new ShopManager();

        System.out.println("Welcome to Car Parts Shop!");

        while (true) {
            shopManager.displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    shopManager.handleViewParts();
                    break;

                case 2:
                    shopManager.handleAddToCart(scanner);
                    break;

                case 3:
                    shopManager.handleViewCart();
                    break;

                case 4:
                    shopManager.handleCheckout();
                    break;

                case 5:
                    System.out.println("\nThank you for shopping with us!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}