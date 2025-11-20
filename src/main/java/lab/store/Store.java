package lab.store;

import java.util.ArrayList;
import java.util.List;

import lab.model.Flower;
import lab.store.flower.FlowerBucket;
import lab.store.flower.FlowerPack;
import lombok.Data;

@Data
public class Store {
    private List<Flower> flowers = new ArrayList<>();
    private List<FlowerBucket> buckets = new ArrayList<>();

    public List<Flower> searchFlowers(Flower flower) {
        List<Flower> result = new ArrayList<>();
        for (Flower f : flowers) {
            if (matchesFlower(f, flower)) {
                result.add(f);
            }
        }
        return result;
    }

    public List<FlowerBucket> searchBucketsByQuantity(int minQuantity, int maxQuantity) {
        List<FlowerBucket> result = new ArrayList<>();
        for (FlowerBucket bucket : buckets) {
            int total = 0;
            for (FlowerPack pack : bucket.getFlowerPacks()) {
                total += pack.getQuantity();
            }
            if (total >= minQuantity && total <= maxQuantity) {
                result.add(bucket);
            }
        }
        return result;
    }

    public List<FlowerBucket> searchBucketsByFlower(Flower flower) {
        List<FlowerBucket> result = new ArrayList<>();
        for (FlowerBucket bucket : buckets) {
            for (FlowerPack pack : bucket.getFlowerPacks()) {
                if (matchesFlower(pack.getFlower(), flower)) {
                    result.add(bucket);
                    break;
                }
            }
        }
        return result;
    }

    public List<FlowerBucket> searchBucketsByPack(FlowerPack pack) {
        List<FlowerBucket> result = new ArrayList<>();
        for (FlowerBucket bucket : buckets) {
            for (FlowerPack pck : bucket.getFlowerPacks()) {
                if (matchesPack(pck, pack)) {
                    result.add(bucket);
                    break;
                }
            }
        }
        return result;
    }

    private boolean matchesFlower(Flower f, Flower flower) {
        if (flower.getColor() != null && f.getColor() != flower.getColor()) {
            return false;
        }
        if (flower.getFlowerType() != null && f.getFlowerType() != flower.getFlowerType()) {
            return false;
        }
        if (flower.getSepalLength() != 0 && f.getSepalLength() != flower.getSepalLength()) {
            return false;
        }
        if (flower.getPrice() != 0 && f.getPrice() > flower.getPrice()) {
            return false;
        }
        return true;
    }

    private boolean matchesPack(FlowerPack firstPack, FlowerPack secondPack) {
        Flower firstFlower = firstPack.getFlower();
        Flower secondFlower = secondPack.getFlower();

        if (secondFlower != null) {
            if (!matchesFlower(firstFlower, secondFlower)) {
                return false;
            }
        }
        if (secondPack.getQuantity() != 0 && firstPack.getQuantity()
                < secondPack.getQuantity()) {
            return false;
        }
        return true;
    }
}
