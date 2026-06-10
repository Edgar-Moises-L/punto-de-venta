package punto_de_venta.sale.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import punto_de_venta.sale.domain.Sale;
import punto_de_venta.sale.domain.SaleRepository;
import punto_de_venta.sale.infrastructure.mapper.SaleMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class SaleMySqlRepository implements SaleRepository {
    private final SaleSpringRepository repository;
    private final SaleMapper mapper;

    @Override
    public Sale save(Sale sale) {
        return null;
    }

    @Override
    public List<Sale> findAll() {
        return List.of();
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }

    @Override
    public Void deleteById(Long id) {
        return null;
    }
}
