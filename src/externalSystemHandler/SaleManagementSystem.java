package externalSystemHandler;

import model.Cart;

import java.util.ArrayList;
import java.util.List;

public class SaleManagementSystem {
    private static List<IObserver> observers;
    DiscountDB discount = new DiscountDB();

    public SaleManagementSystem() {
        observers = new ArrayList<IObserver>();
    }

    public void registerObservers(IObserver system1, IObserver system2) {
        observers.add(system1);
        observers.add(system2);
    }

    public void notifyObservers(String customerId, Cart cart) {
        for(IObserver systems : observers) {
            systems.makeNotis(customerId, cart);
        }
    }

    public Integer requestDiscount(String customerID) {
        Integer discountDTO = discount.searchDiscount(customerID);
        return discountDTO;
    }
}
