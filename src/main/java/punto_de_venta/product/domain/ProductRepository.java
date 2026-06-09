package punto_de_venta.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Boolean existsByName(String name);

    Boolean existsByNameAndIdNot(Long id, String name);

    Boolean existsById(Long id);

    void deleteByid(Long id);

}
