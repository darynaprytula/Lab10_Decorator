package lab.store.flower;

import java.util.ArrayList;
import java.util.List;

import lab.store.Item;
import lombok.Data;

@Data
public class FlowerBucket extends Item {
    private List<FlowerPack> flowerPacks = new ArrayList<>();
    private final List<Item> flowers = new ArrayList<>();

    @Override
    public double getPrice() {
        double total = 0.0;
        for (Item flower : flowers) {
            total += flower.getPrice();
        }
        return total;
    }

    public void addFlowers(Item flower) {
        flowers.add(flower);
    }

    public List<Item> searchFlower(String name) {
        String nameLowerCase = name.toLowerCase();
        return flowers.stream()
                .filter(f -> f.getDescription() != null
                        && f.getDescription().toLowerCase().contains(nameLowerCase))
                .toList();
    }

    public void add(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    @Override
    public String getDescription() {
        if (flowers.isEmpty()) {
            return "Empty flower bucket";
        }

        StringBuilder descriptionBuilder = new StringBuilder("Flower bucket containing: ");
        for (int i = 0; i < flowers.size(); i++) {
            descriptionBuilder.append(flowers.get(i).getDescription());
            if (i < flowers.size() - 1) {
                descriptionBuilder.append(", ");
            }
        }
        return descriptionBuilder.toString();
    }
}
