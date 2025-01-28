package code.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import code.product.data.Product;
import code.product.logic.IProductService;
import code.exception.IllegalOperationException;
import code.exception.NotFoundException;
import code.cart.data.Cart;
import code.cart.data.ICartRepository;
import code.cart.web.bodies.CartEntryRequest;
import code.productInCart.data.ProductInCart;
import code.productInCart.logic.IProductInCartService;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository repository;

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductInCartService productInCartService;

    @Override
    public Cart create() {
        return this.repository.save(new Cart());
    }

    @Override
    public Cart getById(long id) throws NotFoundException {
        Cart cart = this.repository.findCartById(id);
        if (cart == null) {
            throw new NotFoundException();
        }
        return cart;
    }

    @Override
    public void delete(long id) throws NotFoundException {
        Cart cart = this.getById(id);
        this.repository.delete(cart);
    }

    @Override
    public Cart addToCart(long id, CartEntryRequest body) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getUnpayed(id);
        Product product = this.productService.getById(body.getProductId());
        if(product.getAmount() < body.getAmount()) {
            throw new IllegalOperationException();
        }

        boolean isInCart = false;
        for(ProductInCart productInCart : cart.getShoppingList()) {
            if(productInCart.getProduct() == product) {
                isInCart = true;
                break;
            }
        }

        if(isInCart) {
            for(ProductInCart productInCart : cart.getShoppingList()) {
                if(productInCart.getProduct() == product) {
                    productInCart.setAmount(productInCart.getAmount() + body.getAmount());
                }
            }
        }
        else {
            ProductInCart productInCart = this.productInCartService.create(body, product);

            cart.getShoppingList().add(productInCart);
        }

        product.setAmount(product.getAmount() - body.getAmount());
        return this.repository.save(cart);
    }

    @Override
    public double payCart(Long cartId) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getUnpayed(cartId);
        cart.setPayed(true);
        this.repository.save(cart);

        double finalPrice = 0;
        for (ProductInCart p : cart.getShoppingList()) {
            finalPrice += (p.getProduct().getPrice() * p.getAmount());
        }
        return finalPrice;
    }

    private Cart getUnpayed(long id) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getById(id);
        if (cart.isPayed()) {
            throw new IllegalOperationException();
        }
        return cart;
    }
}
