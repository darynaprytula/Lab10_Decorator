package lab.delivery;

import lab.store.delivery.Delivery;
import lab.store.delivery.PostDeliveryStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostDeliveryStrategyTest {

    @Test
    void forOrderPriceAbove1000() {
        Delivery delivery = new PostDeliveryStrategy();
        double result = delivery.deliver(2300);
        assertEquals(0, result, "delivery should be free for orders above 1000");
    }

    @Test
    void forOrderPriceEquals1000() {
        Delivery delivery = new PostDeliveryStrategy();
        double result = delivery.deliver(1000);
        assertEquals(100, result, "delivery costs 100 for price of order 1000");
    }

    @Test
    void forOrderPriceBelow1000() {
        Delivery delivery = new PostDeliveryStrategy();
        double result = delivery.deliver(830);
        assertEquals(100, result, "delivery costs 100 for orders below 1000");
    }
}
