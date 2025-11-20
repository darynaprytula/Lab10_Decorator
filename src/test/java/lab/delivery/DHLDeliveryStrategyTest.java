package lab.delivery;

import lab.store.delivery.DHLDeliveryStrategy;
import lab.store.delivery.Delivery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DHLDeliveryStrategyTest {

    @Test
    void forOrderPriceAbove1500() {
        Delivery delivery = new DHLDeliveryStrategy();
        double result = delivery.deliver(2300);
        assertEquals(0, result, "delivery should be free for orders above 1500");
    }

    @Test
    void forOrderPriceEquals1500() {
        Delivery delivery = new DHLDeliveryStrategy();
        double result = delivery.deliver(1500);
        assertEquals(200, result, "delivery costs 200 for price of order 1500");
    }

    @Test
    void forOrderPriceBelow1500() {
        Delivery delivery = new DHLDeliveryStrategy();
        double result = delivery.deliver(830);
        assertEquals(200, result, "delivery costs 200 for orders below 1500");
    }
}
