package punto_de_venta.sale.domain;

public class SaleDetails {
    private Long id;
    private Long productId;
    private Integer amount;
    private Double unitPrice;
    private Double subTotal;

    public SaleDetails() {

    }

    public SaleDetails(Long id, Long productId, Integer amount, Double unitPrice, Double subTotal) {
        this.id = id;
        this.productId = productId;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
