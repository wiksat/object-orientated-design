package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.filter.FilterSpec;

import java.util.Date;

public class FoodItem extends Item{
    private final Date date;
    public FoodItem(String name, Category category, int price, int quantity, Date date) {
        super(name, category, price, quantity);
        this.date=date;
    }
//    public void setDate(Date date) {
//        ;
//    }
    public Date getDate() {
        return date;
    }

    @Override
    public boolean isAdditionalFieldsAppliedTo(FilterSpec filter) {
        return true;
    }
}
