package externalSystemHandler;

import itemRepository.Item;
import model.Cart;

import java.util.HashMap;
import java.util.Map;

import static itemRepository.ItemCatalog.getItem;

public class Inventory {
    private static HashMap<String, Integer> inventory = new HashMap();

    static {
        inventory.put("Apple", 30);
        inventory.put("Banana", 20);
    }

    public void searchInventory(Cart cart){
        for (Map.Entry<Item, Integer> entry : cart.entrySet()) {
            if(inventory.containsKey(entry.getKey().getName())){
                decreaseInventory(entry.getKey().getName(), cart);
            }
        }
    }
    private void decreaseInventory(String item, Cart cart){
        Integer previousQuantity = inventory.get(item);
        Integer itemRemain = inventory.get(item) - cart.get(getItem(item));
        inventory.replace(item, itemRemain);
        inventoryNotified(item, itemRemain, previousQuantity);
    }
    private void inventoryNotified(String item, Integer itemRemain, Integer previousQuantity){
        System.out.println("Item of type '" + item + "' left in inventory: " + itemRemain + " from " + previousQuantity);
    }

}
