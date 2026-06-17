package punto_de_venta.sale.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import punto_de_venta.sale.domain.Sale;
import punto_de_venta.sale.domain.SaleDetails;
import punto_de_venta.sale.infrastructure.dto.SaleDetailsRequest;
import punto_de_venta.sale.infrastructure.dto.SaleRequest;
import punto_de_venta.sale.infrastructure.dto.SaleResponse;
import punto_de_venta.sale.infrastructure.entity.SaleEntity;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaVenta", ignore = true)
    @Mapping(target = "total", ignore = true)
    Sale saleRequestToSale(SaleRequest saleRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "unitPrice", ignore = true)
    @Mapping(target = "subTotal", ignore = true)
    SaleDetails saleDetailsRequestToSaleDetails(SaleDetailsRequest request);

    SaleEntity saleToSaleEntity(Sale sale);

    Sale saleEntityToSale(SaleEntity saleEntity);

    SaleResponse saleToSaleResponse(Sale sale);

}
