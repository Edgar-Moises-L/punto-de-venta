package punto_de_venta.product.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import punto_de_venta.exceptions.domain.ResoursceNotFoundException;
import punto_de_venta.product.domain.Product;
import punto_de_venta.product.domain.ProductRepository;
import punto_de_venta.product.infrastructure.entity.ProductEntity;
import punto_de_venta.product.infrastructure.mapper.ProductMapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class ProductMySqlRepository implements ProductRepository {
    private final ProductSpringRepository springRepository;
    private final ProductMapper mapper;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = mapper.productToProductEntity(product);
        ProductEntity productSave = springRepository.save(productEntity);
        return mapper.productEntityToProduct(productSave);
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> productEntityList = springRepository.findAll();
        List<Product> productList = productEntityList.stream()
                .map(mapper::productEntityToProduct)
                .toList();
        return productList;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return springRepository.findById(id).map(mapper::productEntityToProduct);
    }

    @Override
    public Boolean existsByName(String name) {
        return springRepository.existsByName(name);
    }

    @Override
    public Boolean existsByNameAndIdNot(Long id, String name) {
        return springRepository.existsByNameAndIdNot(id, name);
    }

    @Override
    public Boolean existsById(Long id) {
        return springRepository.existsById(id);
    }

    @Override
    public void deleteByid(Long id) {
        springRepository.deleteById(id);
    }

    @Override
    public Map<Long, Double> findPriceByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new ResoursceNotFoundException("No se encontraron los precios de los productos");
        }
        List<Object[]> results = springRepository.findPricesByIds(ids);

        return results.stream()
                .collect(Collectors.toMap(
                        row -> ((Number) row[0]).longValue(),
                        row -> ((Number) row[1]).doubleValue()
                ));
    }
}
