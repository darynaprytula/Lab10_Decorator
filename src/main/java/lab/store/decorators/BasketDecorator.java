package lab.store.decorators;

import lab.store.Item;

public class BasketDecorator extends ItemDecorator {
    private static final int ADDITIONAL_PRICE = 4;

    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return ADDITIONAL_PRICE + item.getPrice();
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " placed in a basket decorator";
    }
}