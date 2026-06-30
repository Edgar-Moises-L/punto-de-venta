package punto_de_venta.sale.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import punto_de_venta.sale.domain.Sale;
import punto_de_venta.sale.domain.SaleService;
import punto_de_venta.sale.infrastructure.dto.SaleRequest;
import punto_de_venta.sale.infrastructure.dto.SaleResponse;
import punto_de_venta.sale.infrastructure.mapper.SaleMapper;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sales")
public class SaleControllerImpl implements SaleController {
    private final SaleService service;
    private final SaleMapper mapper;

    @Override
    @PostMapping
    public ResponseEntity<SaleResponse> create(@Valid @RequestBody SaleRequest saleRequest) {
        Sale sale = mapper.saleRequestToSale(saleRequest);
        Sale saleSave = service.createSale(sale);
        SaleResponse saleResponse = mapper.saleToSaleResponse(saleSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(saleResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<SaleResponse>> getAll() {
        List<SaleResponse> saleResponses = service.getAllsale().stream()
                .map(mapper::saleToSaleResponse)
                .toList();
        return ResponseEntity.ok(saleResponses);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SaleResponse> getById(@PathVariable Long id) {
        Sale sale = service.getSaleById(id);
        SaleResponse saleResponse = mapper.saleToSaleResponse(sale);
        return ResponseEntity.ok(saleResponse);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SaleResponse> update(@PathVariable Long id, @Valid @RequestBody SaleRequest saleRequest) {
        Sale sale = mapper.saleRequestToSale(saleRequest);
        Sale saleUpdate = service.updateSale(id, sale);
        SaleResponse saleResponse = mapper.saleToSaleResponse(saleUpdate);
        return ResponseEntity.ok(saleResponse);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
