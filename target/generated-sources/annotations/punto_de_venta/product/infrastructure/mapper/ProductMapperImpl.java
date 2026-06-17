package punto_de_venta.product.infrastructure.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import punto_de_venta.product.domain.Product;
import punto_de_venta.product.domain.ProductType;
import punto_de_venta.product.infrastructure.dto.ProductRequest;
import punto_de_venta.product.infrastructure.dto.ProductResponse;
import punto_de_venta.product.infrastructure.entity.ProductEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-17T12:32:33-0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product productRequestToProduct(ProductRequest productRequest) {
        if ( productRequest == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( productRequest.getName() );
        product.setDescription( productRequest.getDescription() );
        if ( productRequest.getProductType() != null ) {
            product.setProductType( Enum.valueOf( ProductType.class, productRequest.getProductType() ) );
        }
        product.setPrice( productRequest.getPrice() );

        return product;
    }

    @Override
    public ProductEntity productToProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setName( product.getName() );
        productEntity.setDescription( product.getDescription() );
        productEntity.setProductType( product.getProductType() );
        productEntity.setPrice( product.getPrice() );

        return productEntity;
    }

    @Override
    public Product productEntityToProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productEntity.getId() );
        product.setName( productEntity.getName() );
        product.setDescription( productEntity.getDescription() );
        product.setProductType( productEntity.getProductType() );
        product.setPrice( productEntity.getPrice() );

        return product;
    }

    @Override
    public ProductResponse productToProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId( product.getId() );
        productResponse.setName( product.getName() );
        productResponse.setDescription( product.getDescription() );
        if ( product.getProductType() != null ) {
            productResponse.setProductType( product.getProductType().name() );
        }
        productResponse.setPrice( product.getPrice() );

        return productResponse;
    }
}
