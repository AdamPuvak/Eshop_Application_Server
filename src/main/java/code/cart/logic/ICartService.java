package code.cart.logic;

import code.exception.IllegalOperationException;
import code.exception.NotFoundException;
import code.cart.data.Cart;
import code.cart.web.bodies.CartEntryRequest;

public interface ICartService {
    Cart create();

    Cart getById(long id) throws NotFoundException;

    void delete(long id) throws NotFoundException, IllegalOperationException;

    Cart addToCart(long id, CartEntryRequest body) throws NotFoundException, IllegalOperationException;

    double payCart(Long cartId) throws NotFoundException, IllegalOperationException;
}
