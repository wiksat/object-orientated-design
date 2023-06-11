package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.SportItem;

import java.text.ParseException;

public class SportProvider implements Provider{

    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) throws ParseException {
        return new SportItem(name, category, price, quantity);
    }
}
