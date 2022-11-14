package Proyect.MMS.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="saleDetail")
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="saleDetail_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Column(name ="product_list")
    @OneToMany(targetEntity = Product.class)
    @JoinColumn(name = "saleDetail_id")
    private List<Product> productList = new ArrayList<>();

    @Column(name = "total",  scale = 2)
    private Double total;

    public SaleDetail() {
    }

    public SaleDetail(Sale sale, Double total) {
        this.sale = sale;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "SaleDetail{" +
                "id=" + id +
                ", sale=" + sale +
                ", productList=" + productList +
                ", total=" + total +
                '}';
    }
}
