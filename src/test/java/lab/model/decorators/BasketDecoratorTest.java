package lab.model.decorators;

import lab.store.flower.RomashkaFlower;
import lab.store.flower.FlowerBucket;
import lab.store.Item;
import lab.store.decorators.BasketDecorator;
import org.junit.jupiter.api.*;

public class BasketDecoratorTest {
    private Item baseItem;

    @BeforeEach
    void setUp() {
        FlowerBucket bucket = new FlowerBucket();
        bucket.addFlowers(new RomashkaFlower(20));
        baseItem = bucket;
    }

    @Test
    void getPrice_WithBasketDecorator_Ok() {
        Item basket = new BasketDecorator(baseItem);
        double expected = baseItem.getPrice() + 4;
        Assertions.assertEquals(expected, basket.getPrice(), 0.001);
    }

    @Test
    void getDescription_WithBasketDecorator_Ok() {
        Item basket = new BasketDecorator(baseItem);
        String description = basket.getDescription();
        Assertions.assertTrue(description.contains("placed in a basket"));
    }

    @Test
    void getPrice_NullItem_NotOk() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new BasketDecorator(null).getPrice());
    }
}
