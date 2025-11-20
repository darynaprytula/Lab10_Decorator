package lab.store.delivery;

public class PostDeliveryStrategy implements Delivery {
    private static final double DELIVERY_PRICE = 100;
    private static final double FREE_DELIVERY_PRICE = 0;
    private static final double LIMIT = 1000;

    @Override
    public double deliver(double orderPrice) {
        System.out.println("postal delivery");
        if (orderPrice > LIMIT) {
            return FREE_DELIVERY_PRICE;
        }
        return DELIVERY_PRICE;
    }
}

