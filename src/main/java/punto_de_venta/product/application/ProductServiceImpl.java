package punto_de_venta.product.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import punto_de_venta.exceptions.domain.DuplicateResourceException;
import punto_de_venta.exceptions.domain.ResoursceNotFoundException;
import punto_de_venta.product.domain.Product;
import punto_de_venta.product.domain.ProductRepository;
import punto_de_venta.product.domain.ProductService;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product createProduct(Product product) {
        if (repository.existsByName(product.getName())) {
            throw new DuplicateResourceException("El producto que se esta intentando guardar ya existe");
        }
        return repository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductByid(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResoursceNotFoundException("El producto no existe"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product updateProduct(Long id, Product product) {
        if (repository.existsByNameAndIdNot(id, product.getName())) {
            throw new DuplicateResourceException("El producto que se esta intentando guardar ya existe");
        }
        if (repository.existsById(id)) {
            throw new ResoursceNotFoundException("El producto que desea actualizar no existe");
        }

        Product oldProduct = repository.findById(id).orElseThrow(() -> new ResoursceNotFoundException("El producto que desea actualizar no existe"));
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setProductType(product.getProductType());
        oldProduct.setPrice(product.getPrice());
        return repository.save(oldProduct);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new ResoursceNotFoundException("El producto que se quiere eliminar no existe");
        }
        repository.deleteByid(id);
    }

    @Override
    public Map<Long, Double> findPricesByIds(List<Long> ids) {
        return repository.findPriceByIds(ids);
    }

}
