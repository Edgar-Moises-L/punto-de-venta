package punto_de_venta.product.infrastructure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import punto_de_venta.product.domain.ProductService;
import punto_de_venta.product.infrastructure.dto.ProductRequest;
import punto_de_venta.product.infrastructure.dto.ProductResponse;
import punto_de_venta.product.infrastructure.mapper.ProductMapper;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductControllerImpl implements ProductController {
    private final ProductService service;
    private final ProductMapper mapper;

    @Override
    public ResponseEntity<ProductResponse> create(ProductRequest productRequest) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<ProductResponse> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ProductResponse> update(Long id, ProductRequest productRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return null;
    }
}
