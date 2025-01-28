package code.productInCart.logic;

import code.cart.web.bodies.CartEntryRequest;
import code.exception.NotFoundException;
import code.product.data.Product;
import code.productInCart.data.ProductInCart;

public interface IProductInCartService {

    ProductInCart create(CartEntryRequest r, Product product) throws NotFoundException;

}
