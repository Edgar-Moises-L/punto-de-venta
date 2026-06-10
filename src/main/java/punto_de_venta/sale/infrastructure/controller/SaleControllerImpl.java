package punto_de_venta.sale.infrastructure.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<SaleResponse>> getAll() {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SaleResponse> getById(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SaleResponse> update(@Valid @RequestBody @PathVariable Long id, SaleRequest saleRequest) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return null;
    }
}
