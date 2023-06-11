package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.ElectronicItem;
import pl.edu.agh.dronka.shop.model.FoodItem;
import pl.edu.agh.dronka.shop.model.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodProvider implements Provider{

    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) throws ParseException {
        String dateInString = reader.getValue(dataLine, "Data przydatności do spożycia");
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dateInString);
        return new FoodItem(name, category, price, quantity, date);
    }
}
