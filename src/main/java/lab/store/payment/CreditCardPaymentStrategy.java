package lab.store.payment;

public class CreditCardPaymentStrategy implements Payment {

    @Override
    public void pay(final double price) {
        if (price <= 0) {
            throw new UnsupportedOperationException("price must be grater than 0");
        }
        System.out.println("successfull payment by credit card! sum " + price);

    }
}
