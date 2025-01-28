package code.cart.web.bodies;

import lombok.Getter;

@Getter
public class CartEntryRequest {
    private long productId;
    private int amount;
}

