import model.Cart;

public class POS {
    public static void main(String[] args) {

        Cashier cashier = new Cashier();
        Customer customer = new Customer();

        cashier.startNewSale();
        customer.addItemToCart();

        boolean moreItems = customer.additionalItemsQuest();
        if (moreItems) {customer.addItemToCart();}

        cashier.endSale();

        boolean discount = customer.eligibleForDiscount();
        if(discount) {customer.requestDiscount();}

        customer.payment(discount);

        customer.printReceipt();

        customer.saleLog();

    }
}