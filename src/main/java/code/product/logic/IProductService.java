package code.product.logic;

import code.product.data.Product;
import code.product.web.bodies.ProductRequest;
import code.product.web.bodies.ProductUpdateRequest;
import code.exception.NotFoundException;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    Product create(ProductRequest request) throws NotFoundException;

    Product getById(long id) throws NotFoundException;

    Product update(long id, ProductUpdateRequest request) throws NotFoundException;

    void delete(long id) throws NotFoundException;

    int getAmount(long id) throws NotFoundException;

    int addAmount(long id, int increment) throws NotFoundException;

}
