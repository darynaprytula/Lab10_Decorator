package lab.model.decorators;

import lab.store.flower.CactusFlower;
import lab.store.flower.RomashkaFlower;
import lab.store.flower.FlowerBucket;
import lab.store.Item;
import lab.store.decorators.ItemDecorator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemDecoratorTest {
    private Item baseItem;

    @BeforeEach
    void setUp() {
        FlowerBucket bucket = new FlowerBucket();
        bucket.addFlowers(new CactusFlower(10));
        bucket.addFlowers(new RomashkaFlower(5));
        baseItem = bucket;
    }

    @Test
    void constructor_NullItem_NotOk() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new ItemDecorator(null) {
                    @Override
                    public double getPrice() {
                        return 0;
                    }

                    @Override
                    public String getDescription() {
                        return "Test";
                    }
                });
    }

    @Test
    void abstractDecorator_DelegatesMethods_Ok() {
        ItemDecorator decorator = new ItemDecorator(baseItem) {
            @Override
            public double getPrice() {
                return item.getPrice();
            }

            @Override
            public String getDescription() {
                return item.getDescription();
            }
        };

        double expected = baseItem.getPrice();
        Assertions.assertEquals(expected, decorator.getPrice());
        Assertions.assertTrue(decorator.getDescription().contains("Flower"));
    }
}