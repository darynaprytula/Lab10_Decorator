package lab.store.flower;

import lab.store.Item;

public class CactusFlower extends Item {
    private double price;

    public CactusFlower(double price) {
        this.price = price;
        this.description = "Cactus flower";
    }

    public CactusFlower(double price,  String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
