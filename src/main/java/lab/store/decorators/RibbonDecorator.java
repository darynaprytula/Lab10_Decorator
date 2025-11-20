package lab.store.decorators;

import lab.store.Item;

public class RibbonDecorator extends ItemDecorator {
    private static final int ADDITIONAL_PRICE = 40;

    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return ADDITIONAL_PRICE + item.getPrice();
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " decorated with a ribbon decorator";
    }
}