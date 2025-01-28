package code.product.web.bodies;

import lombok.Getter;
import code.product.data.Product;

@Getter
public class ProductResponse {

    private final long id;
    private final String name;
    private final String description;
    private final String unit;
    private final int amount;
    private final double price;

    public ProductResponse(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.unit = p.getUnit();
        this.amount = p.getAmount();
        this.price = p.getPrice();
    }
}
