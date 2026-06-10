package punto_de_venta.sale.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import punto_de_venta.sale.infrastructure.dto.SaleRequest;
import punto_de_venta.sale.infrastructure.dto.SaleResponse;

import java.util.List;

public interface SaleController {
    ResponseEntity<SaleResponse> create(SaleRequest saleRequest);

    ResponseEntity<List<SaleResponse>> getAll();

    ResponseEntity<SaleResponse> getById(Long id);

    ResponseEntity<SaleResponse> update(Long id, SaleRequest saleRequest);

    ResponseEntity<Void> delete(Long id);
}
