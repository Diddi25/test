package itemRepository;

import java.time.LocalDate;

public abstract class ItemDescription {
    public abstract String getName();
    public abstract Integer getPrice();
    public abstract Integer getVAT();
    public abstract LocalDate expireDate();

}
