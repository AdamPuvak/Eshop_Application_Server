package code.productInCart.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductInCartRepository extends JpaRepository<ProductInCart, Long> {

    List<ProductInCart> findAll();

    ProductInCart findProductById(Long id);

}
