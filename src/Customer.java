import externalSystemHandler.AccountingSystem;
import externalSystemHandler.IObserver;
import externalSystemHandler.InventorySystem;
import externalSystemHandler.SaleManagementSystem;
import itemRepository.Item;
import model.Cart;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Customer {
    private String customerId;
    private Integer discount;
    private Cart cart = new Cart();
    private SaleManagementSystem sms = new SaleManagementSystem();
    private Payment payment = new Payment();

    public Payment getPayment() {
        return this.payment;
    }
    public Cart getCart(){
        return this.cart;
    }
    public Customer getCustomer(){
        return this;
    }

    public Cart addItemToCart() {
        System.out.println("Skriv in produkterna i hybridrader i lowercase (avsluta med 'exit'):");
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String product = scanner.nextLine();
            if (product.equalsIgnoreCase("exit")) {
                break;
            }
            cart.scanItem(product);
        }
        return cart;
    }
    public boolean additionalItemsQuest() {
        do {
            System.out.println("you have any more items? (yes/no)");
            Scanner scanner = new Scanner(System.in);
            String moreItems = scanner.nextLine();
            if (moreItems.equalsIgnoreCase("yes")) {
                return true;
            } else if (moreItems.equalsIgnoreCase("no")) {
                return false;
            }
        } while (true);
    }
    public boolean eligibleForDiscount(){
        System.out.println("Do you have any discounts?");
        Scanner scanner = new Scanner(System.in);
        do {
            String discountEligible = scanner.nextLine();
            if (discountEligible.equals("yes")) {
                return true;
            } else if (discountEligible.equals("no")) {
                return false;
            } else {
                System.out.println("please answer yes or no");
            }
        } while(true);
    }
    public void enterCustomerID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter customer ID:");
        customerId = scanner.nextLine();
    }
    public void requestDiscount(){
        enterCustomerID();
        this.discount = sms.requestDiscount(customerId);
    }

    public void payment(boolean ifDiscount){
        if(ifDiscount){
            payment.paymentController(cart, discount);
        } else {
            payment.paymentController(cart, 0);
        }
    }

    public void printReceipt(){
        double totalPrice = payment.getTotalPrice();
        double discounts = payment.getDiscounts();
        double finalPrice = payment.getFinalPrice();
        double change = payment.getChange();
        printsReceipt(cart, totalPrice, discounts, finalPrice, change);
    }

    public void printsReceipt(Cart cart, double totalPrice, double discounts, double finalPrice, double change) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Here is the receipt:");
        System.out.println(" ");
        for (Map.Entry<Item, Integer> item : cart.entrySet()) {
            System.out.print(item.getKey().getName() + " {antal " + item.getValue() + "}");
            System.out.print(" {price: " + item.getKey().getPrice());
            System.out.print(", VAT: " + item.getKey().getVAT());
            System.out.println(", expireDate: " + item.getKey().expireDate() + "}");
        }
        System.out.println("Total price : " + totalPrice);
        System.out.println("Discounts : " + discounts + "%");
        System.out.println("Final price : " + finalPrice);
        System.out.println("Change : " + String.format("%.1f", change));
        System.out.println("Date: " + new Date());
        System.out.println(" ");
    }
    public void saleLog(){
        IObserver InventorySystem = new InventorySystem();
        IObserver AccountingSystem = new AccountingSystem();
        sms.registerObservers(InventorySystem, AccountingSystem);
        sms.notifyObservers(customerId, cart);
    }

}
