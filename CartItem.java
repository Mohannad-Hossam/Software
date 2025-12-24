public class CartItem {
    private CarParts part;
    private int quantity;

    public CartItem(CarParts part, int quantity) {
        this.part = part;
        this.quantity = quantity;
    }

    public CarParts getPart() {
        return part;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return part.getPrice() * quantity;
    }

    public void display() {
        System.out.println(part.getName() + " x" + quantity + " = $" + getSubtotal());
    }
}
