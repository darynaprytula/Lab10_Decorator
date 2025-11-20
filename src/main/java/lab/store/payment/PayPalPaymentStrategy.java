package lab.store.payment;

public class PayPalPaymentStrategy implements Payment {

    @Override
    public void pay(final double price) {
        if (price <= 0) {
            throw new UnsupportedOperationException("price must be grater than 0'");
        }
        System.out.println("successfull payment with paypal! sum " + price);

    }
}
