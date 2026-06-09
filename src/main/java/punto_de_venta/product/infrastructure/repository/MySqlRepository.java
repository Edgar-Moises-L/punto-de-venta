package punto_de_venta.product.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import punto_de_venta.product.domain.Product;
import punto_de_venta.product.domain.ProductRepository;
import punto_de_venta.product.infrastructure.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MySqlRepository implements ProductRepository {
    private final SpringRepository springRepository;
    private final ProductMapper mapper;

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByName(String name) {
        return null;
    }

    @Override
    public Boolean existsByNameAndIdNot(Long id, String name) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }

    @Override
    public void deleteByid(Long id) {

    }
}
