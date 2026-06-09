package punto_de_venta.product.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import punto_de_venta.product.domain.Product;
import punto_de_venta.product.infrastructure.dto.ProductRequest;
import punto_de_venta.product.infrastructure.dto.ProductResponse;
import punto_de_venta.product.infrastructure.entity.ProductEntity;

@Mapper
public interface ProductMapper {
    @Mapping(target = "id" , ignore = true)
    public Product productRequestToProduct(ProductRequest productRequest);

    public ProductEntity productToProductEntity(Product product);

    public Product productEntityToProduct(ProductEntity productEntity);

    public ProductResponse productToProductResponse(Product product);
}
