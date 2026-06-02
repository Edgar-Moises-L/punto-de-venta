package punto_de_venta.product.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import punto_de_venta.product.infrastructure.dto.ProductRequest;
import punto_de_venta.product.infrastructure.dto.ProductResponse;

import java.util.List;

public interface ProductController {
    ResponseEntity<ProductResponse> create(ProductRequest productRequest);

    ResponseEntity<List<ProductResponse>> getAll();

    ResponseEntity<ProductResponse> getById(Long id);

    ResponseEntity<ProductResponse> update(Long id, ProductRequest productRequest);

    ResponseEntity<Void> delete(Long id);
}
