public class CarParts {
    private String name;
    private double price;
    private int stock;

    public CarParts(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void display() {
        System.out.println(name + " - $" + price + " (Stock: " + stock + ")");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        }
    }

    public void addStock(int quantity) {
        stock += quantity;
    }
}
