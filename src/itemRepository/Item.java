package itemRepository;

import java.time.LocalDate;

public class Item extends ItemDescription {
    private String name;
    private Integer price;
    private Integer VAT;
    private LocalDate expireDate;

    public Item(String name, Integer price, Integer VAT, LocalDate expireDate){
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.expireDate = expireDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public Integer getVAT() {
        return VAT;
    }

    @Override
    public LocalDate expireDate() {
        return expireDate;
    }
    @Override
    public String toString() {
        return "Item {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", VAT= " + VAT +
                ", expirationDate=" + expireDate +
                '}';
    }
}
