package lab.model.decorators;

import lab.store.flower.CactusFlower;
import lab.store.flower.FlowerBucket;
import lab.store.Item;
import lab.store.decorators.RibbonDecorator;
import org.junit.jupiter.api.*;

public class RibbonDecoratorTest {
    private Item baseItem;

    @BeforeEach
    void setUp() {
        FlowerBucket bucket = new FlowerBucket();
        bucket.addFlowers(new CactusFlower(30));
        baseItem = bucket;
    }

    @Test
    void getPrice_WithRibbonDecorator_Ok() {
        Item ribbon = new RibbonDecorator(baseItem);
        double expected = baseItem.getPrice() + 40;
        Assertions.assertEquals(expected, ribbon.getPrice(), 0.001);
    }

    @Test
    void getDescription_WithRibbonDecorator_Ok() {
        Item ribbon = new RibbonDecorator(baseItem);
        String description = ribbon.getDescription();
        Assertions.assertTrue(description.contains("decorated with a ribbon"));
    }

    @Test
    void getPrice_NullItem_NotOk() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new RibbonDecorator(null).getPrice());
    }
}
