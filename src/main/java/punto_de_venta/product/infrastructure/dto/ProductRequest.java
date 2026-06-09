package punto_de_venta.product.infrastructure.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotBlank(message = "El nombre es obligatorio y debe contener caracteres válidos.")
    private String name;

    @NotBlank(message = "La descripcion es obligatoria y debe contener caracteres válidos.")
    @Size(max = 500, message = "La descripcion puede tener un maximo de 500 caracteres.")
    private String description;

    @Pattern(
            regexp = "^(ENTRADAS|NATURALES|EMPANIZADOS|HORNEADOS|ESPECIALES|BEBIDAS)$",
            message = "El tipo de producto no es válido. Valores permitidos: [ENTRADAS, NATURALES, EMPANIZADOS, HORNEADOS, ESPECIALES, BEBIDAS]"
    )
    @NotBlank(message = "El tipo de producto es obligatorio y debe contener caracteres válidos.")
    private String productType;

    @NotNull(message = "El precio es obligatorio.")
    @DecimalMin(value = "0.01", message = "El precio mínimo permitido es 0.01.")
    @Digits(integer = 6, fraction = 2, message = "El precio debe tener como máximo 6 dígitos enteros y 2 decimales.")
    private Double price;
}
