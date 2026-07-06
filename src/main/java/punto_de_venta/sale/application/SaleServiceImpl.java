package punto_de_venta.sale.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import punto_de_venta.exceptions.domain.ResoursceNotFoundException;
import punto_de_venta.product.domain.ProductService;
import punto_de_venta.sale.domain.Sale;
import punto_de_venta.sale.domain.SaleDetails;
import punto_de_venta.sale.domain.SaleRepository;
import punto_de_venta.sale.domain.SaleService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ProductService productService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Sale createSale(Sale sale) {
        List<SaleDetails> processedDetails = processedSaleDetails(sale.getDetails());

        double total = processedDetails.stream()
                .mapToDouble(SaleDetails::getSubTotal)
                .sum();

        sale.setFechaVenta(LocalDate.now());
        sale.setDetails(processedDetails);
        sale.setTotal(total);

        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllsale() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new ResoursceNotFoundException("La venta con el id " + id + " no existe"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Sale updateSale(Long id, Sale sale) {
        Sale saleUpdate = saleRepository.findById(id).orElseThrow(() -> new ResoursceNotFoundException("La venta con el id " + id + " no existe"));
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSale(Long id) {
        if (!saleRepository.existById(id)) {
            throw new ResoursceNotFoundException("La venta con el id " + id + " que desea eliminar no existe");
        }
        saleRepository.deleteById(id);
    }
    
    private List<SaleDetails> processedSaleDetails(List<SaleDetails> saleDetails) {
        List<Long> productIds = saleDetails.stream()
                .map(SaleDetails::getProductId)
                .distinct()
                .toList();

        Map<Long, Double> productsPrice = productService.findPricesByIds(productIds);

        return saleDetails.stream().map(saleDetail -> {
            Double price = productsPrice.get(saleDetail.getProductId());

            if (price == null) {
                throw new IllegalArgumentException("precio no encontrado para el producto con id " + saleDetail.getProductId());
            }

            SaleDetails newDetail = new SaleDetails();
            newDetail.setProductId(saleDetail.getProductId());
            newDetail.setAmount(saleDetail.getAmount());
            newDetail.setUnitPrice(price);
            newDetail.setSubTotal(price * saleDetail.getAmount());

            return newDetail;
        }).toList();
    }
}
