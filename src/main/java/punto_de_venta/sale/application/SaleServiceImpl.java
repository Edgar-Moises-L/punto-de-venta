package punto_de_venta.sale.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import punto_de_venta.sale.domain.Sale;
import punto_de_venta.sale.domain.SaleRepository;
import punto_de_venta.sale.domain.SaleService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository repository;

    @Override
    public Sale createSale(Sale sale) {
        return null;
    }

    @Override
    public List<Sale> getAllsale() {
        return List.of();
    }

    @Override
    public Sale getSaleById(Long id) {
        return null;
    }

    @Override
    public Sale updateSale(Long id, Sale sale) {
        return null;
    }

    @Override
    public Void deleteSale(Long id) {
        return null;
    }
}
