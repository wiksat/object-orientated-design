package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.filter.FilterSpec;

public class ElectronicItem extends Item{
    private final boolean guarantee;
    private final boolean mobile;
    public ElectronicItem(String name, Category category, int price, int quantity, boolean guarantee, boolean mobile) {
        super(name, category, price, quantity);
        this.guarantee=guarantee;
        this.mobile=mobile;
    }
    public boolean getGuarantee() {
        return guarantee;
    }

    public boolean getMobile() {
        return mobile;
    }

    @Override
    public boolean isAdditionalFieldsAppliedTo(FilterSpec filter) {
        // applies filter only if the flag (secondHand) is true)
        if (filter.isMobile() && !getMobile()) {
            return false;
        }

        // applies filter only if the flag (polish) is true)
        if (filter.isUnderWarranty() && !getGuarantee()) {
            return false;
        }

        return true;
    }
}
