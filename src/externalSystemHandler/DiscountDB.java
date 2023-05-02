package externalSystemHandler;

import java.util.HashMap;

public class DiscountDB {
    private static HashMap<String, Integer> discountCatalog = new HashMap();

    static {
        discountCatalog.put("34", 20);
        discountCatalog.put("450", 50);
        discountCatalog.put("123", 30);
        discountCatalog.put("24", 10);
    }
    public Integer searchDiscount(String customerID) {
        Integer discountDTO = fetchDiscount(discountCatalog.containsKey(customerID), customerID);
        return discountDTO;
    }

    private static int fetchDiscount(boolean eligibleDiscount, String costumerID) {
        if(eligibleDiscount) {
            return discountCatalog.get(costumerID);
        } else {
            return 0;
        }
    }

}
