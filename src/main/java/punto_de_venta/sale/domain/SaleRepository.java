package punto_de_venta.sale.domain;

import java.util.List;
import java.util.Optional;

public interface SaleRepository {
    Sale save(Sale sale);

    List<Sale> findAll();

    Optional<Sale> findById(Long id);

    Boolean existById(Long id);

    Void deleteById(Long id);
}
