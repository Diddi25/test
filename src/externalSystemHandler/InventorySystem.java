package externalSystemHandler;

import model.Cart;

import java.text.SimpleDateFormat;
import java.util.*;

public class InventorySystem implements IObserver {
    private static final String notis = "Inventory System notified";
    private Inventory inventory1 = new Inventory();
    private LinkedList<Cart> inventory = new LinkedList<>();
    private Map<String, StringBuilder> inventoryLog = new HashMap<>();

    @Override
    public void noteFormat() {
        System.out.println(" ");
        System.out.println(notis);
    }
    @Override
    public void makeNotis(String customerID, Cart cart) {
        noteFormat();

        inventory.add(cart);
        StringBuilder value = new StringBuilder(itemsStringFormat(inventory));
        value.append(currentDate());
        inventoryLog.put(customerID, value);
        inventory1.searchInventory(cart);
        //iterateLog(inventoryLog);
    }
    @Override
    public StringBuilder itemsStringFormat(LinkedList<Cart> inventoryLog) {
        StringBuilder stringBuilder = new StringBuilder();
        ListIterator<Cart> listIterator = inventoryLog.listIterator();

        while (listIterator.hasNext()) {
            stringBuilder.append(listIterator.next()).append(" ");
        }
        return stringBuilder;
    }
    @Override
    public String currentDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date saleDate = new Date();
        String date = "Date: " + formatter.format(saleDate);
        return date;
    }
    @Override
    public void iterateLog(Map<String, StringBuilder> inventoryLog) {
        for (Map.Entry<String,StringBuilder> entry : inventoryLog.entrySet())
            System.out.println("CustomerID = " + entry.getKey() + ", ITEMS = " + entry.getValue());
    }
}
