public class Cart {
    private CartItem[] items;
    private int itemCount;
    private int maxCapacity;

    public Cart() {
        this.maxCapacity = 20;
        this.items = new CartItem[maxCapacity];
        this.itemCount = 0;
    }

    public boolean addItem(CarParts part, int quantity) {
        if (itemCount >= maxCapacity) {
            System.out.println("Cart is full!");
            return false;
        }


        for (int i = 0; i < itemCount; i++) {
            if (items[i].getPart() == part) {
                items[i].setQuantity(items[i].getQuantity() + quantity);
                return true;
            }
        }


        items[itemCount] = new CartItem(part, quantity);
        itemCount++;
        return true;
    }

    public void removeItem(int index) {
        if (index >= 0 && index < itemCount) {
            // Shift items left
            for (int i = index; i < itemCount - 1; i++) {
                items[i] = items[i + 1];
            }
            items[itemCount - 1] = null;
            itemCount--;
        }
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public void clear() {
        for (int i = 0; i < itemCount; i++) {
            items[i] = null;
        }
        itemCount = 0;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getSubtotal();
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public CartItem getItem(int index) {
        if (index >= 0 && index < itemCount) {
            return items[index];
        }
        return null;
    }

    public CartItem[] getAllItems() {
        CartItem[] result = new CartItem[itemCount];
        for (int i = 0; i < itemCount; i++) {
            result[i] = items[i];
        }
        return result;
    }
}
