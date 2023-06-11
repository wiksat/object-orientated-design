package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.filter.FilterSpec;

public class SportItem extends Item{

    public SportItem(String name, Category category, int price, int quantity) {
        super(name, category, price, quantity);
    }

    @Override
    public boolean isAdditionalFieldsAppliedTo(FilterSpec filter) {
        return true;
    }
}
