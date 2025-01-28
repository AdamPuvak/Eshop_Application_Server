package code.product.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import code.product.web.bodies.ProductRequest;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String unit;

    private int amount;

    private double price;

    public Product(ProductRequest r) {
        this.name = r.getName();
        this.description = r.getDescription();
        this.unit = r.getUnit();
        this.amount = r.getAmount();
        this.price = r.getPrice();
    }
}
