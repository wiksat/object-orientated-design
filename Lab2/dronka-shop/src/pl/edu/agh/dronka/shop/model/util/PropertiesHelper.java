package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.*;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());
		if(item.getCategory()== Category.BOOKS){
			propertiesMap.put("Liczba stron", ((BookItem)item).getPagesAmount());
			propertiesMap.put("Twarda oprawa", ((BookItem)item).getHardCover());
		}
		if(item.getCategory()== Category.ELECTRONICS){
			propertiesMap.put("Mobilny", ((ElectronicItem)item).getMobile());
			propertiesMap.put("Gwarancja", ((ElectronicItem)item).getGuarantee());
		}
		if(item.getCategory()== Category.FOOD){
			propertiesMap.put("Data przydatności do spożycia", ((FoodItem)item).getDate());
		}
		if(item.getCategory()== Category.MUSIC){
			propertiesMap.put("Gatunek muzyczny", ((MusicItem)item).getMusicGenre());
			propertiesMap.put("Dołączone wideo", ((MusicItem)item).getVideoPresent());
		}
		
		return propertiesMap;
	}
}
