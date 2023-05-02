package model;

import itemRepository.Item;
import itemRepository.ItemCatalog;
import java.util.HashMap;

public class Cart extends HashMap<Item, Integer> { //map av produkt objekt, antalet av det
    public void scanItem(String itemName) {
        Item item = ItemCatalog.getItem(itemName); // returnerar värdet av ItemCatalog (typ=Item) av nyckeln = produkt
        if (item == null) {
            System.out.println("item invalid");
            return;
        }
        System.out.println(item.toString());
        countItem(item);
    }
    private void countItem(Item item) {
        Integer numberOfProducts = this.get(item); //hämtar map.value (antalet produkter)
        if (numberOfProducts != null) {
            addItem(item, numberOfProducts);
        } else {
            addItem(item, 0);
        }
    }
    private void addItem(Item item, Integer numberOfProducts) {
        this.put(item, ++numberOfProducts); //this = cart = map
    }

}
