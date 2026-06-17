package punto_de_venta.sale.infrastructure.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class SaleRequest {
    @NotEmpty(message = "La venta debe tener al menos un producto")
    @Valid
    private List<SaleDetailsRequest> details = new ArrayList<>();
}
