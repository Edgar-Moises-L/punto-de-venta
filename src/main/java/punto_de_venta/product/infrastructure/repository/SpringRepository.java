package punto_de_venta.product.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import punto_de_venta.product.infrastructure.entity.ProductEntity;

@Repository
public interface SpringRepository extends JpaRepository<ProductEntity,Long> {
}
