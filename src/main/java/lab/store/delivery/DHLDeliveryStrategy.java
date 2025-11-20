package lab.store.delivery;

public class DHLDeliveryStrategy implements Delivery {
    private static final double DELIVERY_PRICE = 200;
    private static final double FREE_DELIVERY_PRICE = 0;
    private static final double LIMIT = 1500;

    @Override
    public double deliver(double orderPrice) {
        System.out.println("DHL delivery");
        if (orderPrice > LIMIT) {
            return FREE_DELIVERY_PRICE;
        }
        return DELIVERY_PRICE;
    }
}
