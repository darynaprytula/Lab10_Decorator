package lab.store.flower;

import lab.model.Flower;
import lombok.Data;

@Data
public class FlowerPack {
    private Flower flower;
    private int quantity;

    public FlowerPack(Flower flower, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity can't be negative");
        }
        this.flower = flower;
        this.quantity = quantity;
    }

    public double getPrice() {
        return flower.getPrice() * quantity;
    }
}
