package code.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import code.exception.IllegalOperationException;
import code.exception.NotFoundException;
import code.cart.logic.ICartService;
import code.cart.web.bodies.CartEntryRequest;
import code.cart.web.bodies.CartResponse;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> addCart() {
        return new ResponseEntity<>(new CartResponse(this.service.create()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse getCart(@PathVariable("id") long cartId) throws NotFoundException {
        return new CartResponse(this.service.getById(cartId));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long cartId) throws NotFoundException, IllegalOperationException  {
        this.service.delete(cartId);
    }

    @PostMapping(value = "/{id}/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse addToCart(@PathVariable("id") Long cartId, @RequestBody CartEntryRequest body) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.service.addToCart(cartId, body));
    }

    @GetMapping(value = "/{id}/pay", produces = MediaType.TEXT_PLAIN_VALUE)
    public String payCart(@PathVariable("id") Long cartId) throws NotFoundException, IllegalOperationException {
        return " " + this.service.payCart(cartId);
    }
}
