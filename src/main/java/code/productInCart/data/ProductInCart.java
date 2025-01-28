package code.productInCart.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import code.cart.web.bodies.CartEntryRequest;
import code.product.data.Product;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductInCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;

    private int amount;

    public ProductInCart(CartEntryRequest r, Product product) {
        this.product = product;
        this.amount = r.getAmount();
    }
}
