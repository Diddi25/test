package externalSystemHandler;

import model.Cart;

import java.text.SimpleDateFormat;
import java.util.*;

public class AccountingSystem implements IObserver {
    private static final String notis = "Accounting System notified";
    private LinkedList<Cart> accounting = new LinkedList<>();
    private Map<String, StringBuilder> accountLog = new HashMap<>();

    @Override
    public void noteFormat() {
        System.out.println(" ");
        System.out.println(notis);
    }
    @Override
    public void makeNotis(String customerID, Cart cart) {
        noteFormat();

        accounting.add(cart);
        StringBuilder valueInAccountLog = new StringBuilder(itemsStringFormat(accounting));
        valueInAccountLog.append(currentDate());
        accountLog.put(customerID, valueInAccountLog);
        iterateLog(accountLog);
    }
    @Override
    public StringBuilder itemsStringFormat(LinkedList<Cart> accountingLog) {
        StringBuilder stringBuilder = new StringBuilder();
        ListIterator<Cart> listIterator = accountingLog.listIterator();

        while (listIterator.hasNext()) {
            stringBuilder.append(listIterator.next()).append(" ");
        }
        return stringBuilder;
    }
    @Override
    public String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date saleDate = new Date();
        String date = "Date: " + formatter.format(saleDate);
        return date;
    }
    @Override
    public void iterateLog(Map<String, StringBuilder> accountingLog) {
        for (Map.Entry<String,StringBuilder> entry : accountingLog.entrySet())
            System.out.println("CustomerID = " + entry.getKey() + ", ITEMS = " + entry.getValue());
    }
}
