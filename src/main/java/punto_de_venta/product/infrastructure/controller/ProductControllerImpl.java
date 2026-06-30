package punto_de_venta.product.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import punto_de_venta.product.domain.Product;
import punto_de_venta.product.domain.ProductService;
import punto_de_venta.product.infrastructure.dto.ProductRequest;
import punto_de_venta.product.infrastructure.dto.ProductResponse;
import punto_de_venta.product.infrastructure.mapper.ProductMapper;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductControllerImpl implements ProductController {
    private final ProductService service;
    private final ProductMapper mapper;

    @Override
    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest productRequest) {
        Product product = mapper.productRequestToProduct(productRequest);
        Product productReturn = service.createProduct(product);
        ProductResponse productResponse = mapper.productToProductResponse(productReturn);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<ProductResponse> productResponses = service.getAllProducts()
                .stream()
                .map(mapper::productToProductResponse)
                .toList();
        return ResponseEntity.ok(productResponses);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id) {
        Product product = service.getProductByid(id);
        ProductResponse productResponse = mapper.productToProductResponse(product);
        return ResponseEntity.ok(productResponse);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@Valid @PathVariable Long id, @RequestBody ProductRequest productRequest) {
        Product product = mapper.productRequestToProduct(productRequest);
        Product productUpdate = service.updateProduct(id, product);
        ProductResponse productResponse = mapper.productToProductResponse(productUpdate);
        return ResponseEntity.ok(productResponse);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
