package code.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import code.product.data.Product;
import code.product.data.IProductRepository;
import code.product.web.bodies.ProductRequest;
import code.product.web.bodies.ProductUpdateRequest;
import code.exception.NotFoundException;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product create(ProductRequest request) throws NotFoundException {
        Product p = this.repository.save(new Product(request));
        return p;
    }

    @Override
    public Product getById(long id) throws NotFoundException {
        Product p = this.repository.findProductById(id);
        if (p == null) {
            throw new NotFoundException();
        }
        return p;
    }

    @Override
    public Product update(long id, ProductUpdateRequest request) throws NotFoundException {
        Product p = this.getById(id);
        if (request.getName() != null) {
            p.setName(request.getName());
        }
        if (request.getDescription() != null) {
            p.setDescription(request.getDescription());
        }
        return this.repository.save(p);
    }

    @Override
    public void delete(long id) throws NotFoundException {
        Product p = this.getById(id);
        this.repository.delete(p);
    }

    @Override
    public int getAmount(long id) throws NotFoundException {
        return this.getById(id).getAmount();
    }

    @Override
    public int addAmount(long id, int increment) throws NotFoundException {
        Product p = this.getById(id);
        p.setAmount(p.getAmount() + increment);
        this.repository.save(p);
        return p.getAmount();
    }

}
