package punto_de_venta.sale.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import punto_de_venta.sale.infrastructure.entity.SaleEntity;

@Repository
public interface SaleSpringRepository extends JpaRepository<SaleEntity, Long> {

}
