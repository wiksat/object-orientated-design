package pl.edu.agh.dronka.shop.model.provider;


import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.ElectronicItem;
import pl.edu.agh.dronka.shop.model.Item;

public class ElectronicProvider implements Provider {
    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader){
        boolean mobile = Boolean.parseBoolean(reader.getValue(dataLine, "Mobilny"));
        boolean guarantee = Boolean.parseBoolean(reader.getValue(dataLine, "Gwarancja"));
        return new ElectronicItem(name, category, price, quantity, mobile, guarantee);
    }
}
