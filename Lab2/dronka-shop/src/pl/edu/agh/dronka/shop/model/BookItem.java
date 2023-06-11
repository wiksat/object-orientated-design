package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.filter.FilterSpec;

public class BookItem extends Item {
    private final boolean isHardCover;
    private final int pagesAmount;
    public BookItem(String name, Category category, int price, int quantity, int pagesAmount, boolean isHardCover) {
        super(name, category, price, quantity);
        this.pagesAmount = pagesAmount;
        this.isHardCover = isHardCover;
    }
    public int getPagesAmount() {
        return this.pagesAmount;
    }

    public boolean getHardCover() {
        return isHardCover;
    }

    @Override
    public boolean isAdditionalFieldsAppliedTo(FilterSpec filter) {
        return !filter.isHardCover() || isHardCover;
    }
}
