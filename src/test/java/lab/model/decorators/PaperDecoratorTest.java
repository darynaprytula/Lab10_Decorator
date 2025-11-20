package lab.model.decorators;

import lab.store.flower.CactusFlower;
import lab.store.flower.FlowerBucket;
import lab.store.Item;
import lab.store.decorators.PaperDecorator;
import org.junit.jupiter.api.*;

public class PaperDecoratorTest {
    private Item baseItem;

    @BeforeEach
    void setUp() {
        FlowerBucket bucket = new FlowerBucket();
        bucket.addFlowers(new CactusFlower(10));
        baseItem = bucket;
    }

    @Test
    void getPrice_WithPaperDecorator_Ok() {
        Item paper = new PaperDecorator(baseItem);
        double expected = baseItem.getPrice() + 13;
        Assertions.assertEquals(expected, paper.getPrice(), 0.001);
    }

    @Test
    void getDescription_WithPaperDecorator_Ok() {
        Item paper = new PaperDecorator(baseItem);
        String description = paper.getDescription();
        Assertions.assertTrue(description.contains("wrapped in paper"));
    }

    @Test
    void getPrice_NullItem_NotOk() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new PaperDecorator(null).getPrice());
    }
}
