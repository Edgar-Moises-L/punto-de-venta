package punto_de_venta.sale.infrastructure.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleResponse {
    private Long id;
    private LocalDate fechaVenta;
    private Double total;
    private List<SaleDetailsResponse> details = new ArrayList<>();
}
