package punto_de_venta.product.domain;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductByid(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
