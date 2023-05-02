import externalSystemHandler.Inventory;
import itemRepository.Item;
import model.Cart;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    @Test
    void compareCartKeyAndInventoryKey(){

        Item item = new Item("Apple", 13, 8, LocalDate.of(2025, 05, 07));

        Cart cart = new Cart();
        cart.put(item, 3);

        Inventory compareKeys = new Inventory();
        assertTrue(compareKeys.searchInventory(cart));


    }
}