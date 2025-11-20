package lab.store.flower;

import lab.store.Item;

public class RomashkaFlower extends Item {
    private double price;

    public RomashkaFlower(double price) {
        this.price = price;
        this.description = "Romashka flower";
    }

    public RomashkaFlower(double price,  String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
