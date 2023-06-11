package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.filter.FilterSpec;

public class MusicItem extends Item{
    private final MusicGenre genre;
    private final boolean videoPresent;
    public MusicItem(String name, Category category, int price, int quantity, MusicGenre genre, boolean isVideoPresent) {
        super(name, category, price, quantity);
        this.genre=genre;
        this.videoPresent=isVideoPresent;
    }


    public MusicGenre getMusicGenre() {
        return this.genre;
    }


    public boolean getVideoPresent() {
        return this.videoPresent;
    }

    @Override
    public boolean isAdditionalFieldsAppliedTo(FilterSpec filter) {
        return !filter.isWithVideo() || getVideoPresent();
    }
}
