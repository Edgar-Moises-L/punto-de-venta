package punto_de_venta.sale.domain;

import java.util.List;

public interface SaleService {
    Sale createSale(Sale sale);

    List<Sale> getAllsale();

    Sale getSaleById(Long id);

    Sale updateSale(Long id, Sale sale);

    Void deleteSale(Long id);

}
