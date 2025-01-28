package code.productInCart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import code.cart.web.bodies.CartEntryRequest;
import code.productInCart.data.IProductInCartRepository;
import code.product.data.Product;
import code.productInCart.data.ProductInCart;

@Service
public class ProductInCartService implements IProductInCartService {

    @Autowired
    private IProductInCartRepository repository;

    @Override
    public ProductInCart create(CartEntryRequest r, Product product) {
        return this.repository.save(new ProductInCart(r, product));
    }

}
