package punto_de_venta.sale.infrastructure.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleResponse {
    private Long id;
    private LocalDateTime fechaVenta;
    private Double total;
    private List<SaleDetailsResponse> details = new ArrayList<>();
}
