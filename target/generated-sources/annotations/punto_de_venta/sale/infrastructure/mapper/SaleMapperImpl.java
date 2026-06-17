package punto_de_venta.sale.infrastructure.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import punto_de_venta.sale.domain.Sale;
import punto_de_venta.sale.domain.SaleDetails;
import punto_de_venta.sale.infrastructure.dto.SaleDetailsRequest;
import punto_de_venta.sale.infrastructure.dto.SaleRequest;
import punto_de_venta.sale.infrastructure.dto.SaleResponse;
import punto_de_venta.sale.infrastructure.entity.SaleDetailsEntity;
import punto_de_venta.sale.infrastructure.entity.SaleEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-17T12:32:33-0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class SaleMapperImpl implements SaleMapper {

    @Override
    public Sale saleRequestToSale(SaleRequest saleRequest) {
        if ( saleRequest == null ) {
            return null;
        }

        Sale sale = new Sale();

        return sale;
    }

    @Override
    public SaleDetails saleDetailsRequestToSaleDetails(SaleDetailsRequest request) {
        if ( request == null ) {
            return null;
        }

        SaleDetails saleDetails = new SaleDetails();

        return saleDetails;
    }

    @Override
    public SaleEntity saleToSaleEntity(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        SaleEntity saleEntity = new SaleEntity();

        saleEntity.setId( sale.getId() );
        saleEntity.setFechaVenta( sale.getFechaVenta() );
        saleEntity.setTotal( sale.getTotal() );
        saleEntity.setDetails( saleDetailsListToSaleDetailsEntityList( sale.getDetails() ) );

        return saleEntity;
    }

    @Override
    public Sale saleEntityToSale(SaleEntity saleEntity) {
        if ( saleEntity == null ) {
            return null;
        }

        Sale sale = new Sale();

        sale.setId( saleEntity.getId() );
        sale.setFechaVenta( saleEntity.getFechaVenta() );
        sale.setTotal( saleEntity.getTotal() );
        sale.setDetails( saleDetailsEntityListToSaleDetailsList( saleEntity.getDetails() ) );

        return sale;
    }

    @Override
    public SaleResponse saleToSaleResponse(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        SaleResponse saleResponse = new SaleResponse();

        return saleResponse;
    }

    protected SaleDetailsEntity saleDetailsToSaleDetailsEntity(SaleDetails saleDetails) {
        if ( saleDetails == null ) {
            return null;
        }

        SaleDetailsEntity saleDetailsEntity = new SaleDetailsEntity();

        saleDetailsEntity.setId( saleDetails.getId() );
        saleDetailsEntity.setProductId( saleDetails.getProductId() );
        saleDetailsEntity.setAmount( saleDetails.getAmount() );
        saleDetailsEntity.setUnitPrice( saleDetails.getUnitPrice() );
        saleDetailsEntity.setSubTotal( saleDetails.getSubTotal() );

        return saleDetailsEntity;
    }

    protected List<SaleDetailsEntity> saleDetailsListToSaleDetailsEntityList(List<SaleDetails> list) {
        if ( list == null ) {
            return null;
        }

        List<SaleDetailsEntity> list1 = new ArrayList<SaleDetailsEntity>( list.size() );
        for ( SaleDetails saleDetails : list ) {
            list1.add( saleDetailsToSaleDetailsEntity( saleDetails ) );
        }

        return list1;
    }

    protected SaleDetails saleDetailsEntityToSaleDetails(SaleDetailsEntity saleDetailsEntity) {
        if ( saleDetailsEntity == null ) {
            return null;
        }

        SaleDetails saleDetails = new SaleDetails();

        saleDetails.setId( saleDetailsEntity.getId() );
        saleDetails.setProductId( saleDetailsEntity.getProductId() );
        saleDetails.setAmount( saleDetailsEntity.getAmount() );
        saleDetails.setUnitPrice( saleDetailsEntity.getUnitPrice() );
        saleDetails.setSubTotal( saleDetailsEntity.getSubTotal() );

        return saleDetails;
    }

    protected List<SaleDetails> saleDetailsEntityListToSaleDetailsList(List<SaleDetailsEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SaleDetails> list1 = new ArrayList<SaleDetails>( list.size() );
        for ( SaleDetailsEntity saleDetailsEntity : list ) {
            list1.add( saleDetailsEntityToSaleDetails( saleDetailsEntity ) );
        }

        return list1;
    }
}
