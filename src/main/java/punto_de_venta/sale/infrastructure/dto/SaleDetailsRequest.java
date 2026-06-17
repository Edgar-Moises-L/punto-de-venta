package punto_de_venta.sale.infrastructure.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SaleDetailsRequest {
    @NotNull(message = "El ID del producto es obligatorio")
    private Long productId;
    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad mínima es 1")
    private Integer amount;
}
