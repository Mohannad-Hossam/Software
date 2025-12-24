public class Inventory {
    private CarParts[] parts;
    private int partCount;
    private int maxCapacity;

    public Inventory() {
        this.maxCapacity = 50;
        this.parts = new CarParts[maxCapacity];
        this.partCount = 0;
    }

    public void addPart(CarParts part) {
        if (partCount < maxCapacity) {
            parts[partCount] = part;
            partCount++;
        } else {
            System.out.println("Inventory is full!");
        }
    }

    public CarParts getPart(int index) {
        if (index >= 0 && index < partCount) {
            return parts[index];
        }
        return null;
    }

    public CarParts[] getAllParts() {
        CarParts[] result = new CarParts[partCount];
        for (int i = 0; i < partCount; i++) {
            result[i] = parts[i];
        }
        return result;
    }

    public int getPartCount() {
        return partCount;
    }

    public void displayAll() {
        System.out.println("\n--- Available Parts ---");
        for (int i = 0; i < partCount; i++) {
            System.out.print((i + 1) + ". ");
            parts[i].display();
        }
    }

    public CarParts findPartByName(String name) {
        for (int i = 0; i < partCount; i++) {
            if (parts[i].getName().equalsIgnoreCase(name)) {
                return parts[i];
            }
        }
        return null;
    }
}
