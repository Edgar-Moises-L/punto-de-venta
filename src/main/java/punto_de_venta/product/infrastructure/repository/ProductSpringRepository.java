package punto_de_venta.product.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import punto_de_venta.product.infrastructure.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductSpringRepository extends JpaRepository<ProductEntity, Long> {

    Boolean existsByNameAndIdNot(Long id, String name);

    Boolean existsByName(String name);

    // Trae un mapa o lista de precios pasando todos los IDs juntos
    @Query("SELECT p.id, p.price FROM ProductEntity p WHERE p.id IN :ids")
    List<Object[]> findPricesByIds(@Param("ids") List<Long> ids);
}
