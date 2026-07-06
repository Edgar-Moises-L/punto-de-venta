package punto_de_venta.product.domain;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductByid(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    Map<Long, Double> findPricesByIds(List<Long> ids);

}
