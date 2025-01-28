package code.productInCart.web.bodies;

import lombok.Getter;
import code.productInCart.data.ProductInCart;

@Getter
public class ProductInCartResponse {

    private final long productId;
    private final int amount;

    public ProductInCartResponse(ProductInCart p) {
        this.productId = p.getProduct().getId();
        this.amount = p.getAmount();
    }
}
