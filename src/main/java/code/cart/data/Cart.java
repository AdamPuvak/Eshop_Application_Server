package code.cart.data;

import lombok.Data;
import code.productInCart.data.ProductInCart;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<ProductInCart> shoppingList;

    private boolean payed;

    public Cart() {
        this.shoppingList = new ArrayList<>();
    }

}

