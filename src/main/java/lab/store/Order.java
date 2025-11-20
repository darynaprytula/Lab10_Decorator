package lab.store;

import java.util.LinkedList;
import java.util.List;
import lab.store.delivery.Delivery;
import lab.store.payment.Payment;
import lombok.Data;

@Data
public class Order {
    private List<Item> items;
    private Delivery delivery;
    private Payment payment;

    public Order() {
        this.items = new LinkedList<>();
    }

    public void setPaymentStrategy(Payment paymentStrategy) {
        this.payment = paymentStrategy;
    }

    public void setDeliveryStrategy(Delivery deliveryStrategy) {
        this.delivery = deliveryStrategy;
    }


    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }

    public void processOrder() {
        if (payment == null || delivery == null) {
            System.out.println("Payment and delivery have not been set");
            return;
        }

        double subtotal = calculateTotalPrice();
        double deliveryCost = delivery.deliver(subtotal);
        double total = subtotal + deliveryCost;

        payment.pay(total);
    }
}
