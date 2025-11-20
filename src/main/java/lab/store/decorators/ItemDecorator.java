package lab.store.decorators;

import lab.store.Item;

public abstract class ItemDecorator extends Item {
    protected final Item item;

    protected ItemDecorator(Item item) {
        if (item == null) {
            throw new NullPointerException("Wrapped Item cannot be null");
        }
        this.item = item;
    }

    @Override
    public abstract String getDescription();
}
