package punto_de_venta.product.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import punto_de_venta.product.domain.Product;
import punto_de_venta.product.domain.ProductRepository;
import punto_de_venta.product.domain.ProductService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductByid(Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
