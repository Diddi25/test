package itemRepository;

import java.time.LocalDate;
import java.util.HashMap;

public class ItemCatalog {
    private static HashMap<String, Item> ItemCatalog = new HashMap();

    static {
        ItemCatalog.put("apple", new Item("Apple", 13, 8, LocalDate.of(2025, 05, 07)));
        ItemCatalog.put("banana", new Item("Banana", 8, 5, LocalDate.of(2024, 04, 30)));
    }

    public static Item getItem(String productID) {
        return ItemCatalog.get(productID.toLowerCase());
    }

}
