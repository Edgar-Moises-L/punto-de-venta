package punto_de_venta.product.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import punto_de_venta.product.domain.ProductRepository;

@RequiredArgsConstructor
@Repository
public class MySqlRepository implements ProductRepository {

}
