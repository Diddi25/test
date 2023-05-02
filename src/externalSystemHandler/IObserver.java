package externalSystemHandler;

import model.Cart;

import java.util.LinkedList;
import java.util.Map;

public interface IObserver {
    void noteFormat();

    void makeNotis(String customerID, Cart cart);

    StringBuilder itemsStringFormat(LinkedList<Cart> systemLog);

    String currentDate();

    void iterateLog(Map<String, StringBuilder> inventoryLog);

}
