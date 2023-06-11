package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.*;

import java.text.ParseException;

public class MusicProvider implements Provider{
    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) throws ParseException {
        MusicGenre genre = MusicGenre.valueOf(reader.getValue(dataLine, "Gatunek muzyczny"));
        boolean isVideoPresent = Boolean.parseBoolean(reader.getValue(dataLine, "Dołączone video"));
        return new MusicItem(name, category, price, quantity, genre,isVideoPresent);
    }
}
