package punto_de_venta.sale.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    private Long id;
    private LocalDateTime fechaVenta;
    private Double total;
    private List<SaleDetails> details = new ArrayList<>();

    public Sale() {

    }

    public Sale(Long id, LocalDateTime fechaVenta, Double total, List<SaleDetails> details) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<SaleDetails> getDetails() {
        return details;
    }

    public void setDetails(List<SaleDetails> details) {
        this.details = details;
    }
}
