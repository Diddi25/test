import model.Cart;
import itemRepository.Item;

import java.util.Map;
import java.util.Scanner;

public class Payment {
    private double totalPrice;
    private double discount;
    private double finalPrice;
    private double change;

    public double getTotalPrice() {
        return totalPrice;
    }
    public double getDiscounts() {
        return discount;
    }
    public double getFinalPrice() {
        return finalPrice;
    }
    public double getChange() {
        return change;
    }

    public void paymentController(Cart cart, double discount) {
        this.discount = discount;
        totalPrice = getTotal(cart);
        finalPrice = calculateDiscount(totalPrice, discount);
        double cash = pay(finalPrice);
        calculateChange(cash, finalPrice);
    }
    private double getTotal(Cart cart) {
        for (Map.Entry<Item, Integer> item : cart.entrySet()) {
            totalPrice = (item.getKey().getPrice() * item.getValue()) + totalPrice;
        }
        return totalPrice;
    }
    private double calculateDiscount(double totalPrice, double discount) {
        return totalPrice - (totalPrice*(discount/100));
    }
    private double pay(Double finalPrice) {
        System.out.println("That will be " + finalPrice + " please");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
    private void calculateChange(double cash, double finalPrice) {
        change = cash - finalPrice;
    }

}
