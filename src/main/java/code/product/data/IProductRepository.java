package code.product.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Product findProductById(Long id);

}
