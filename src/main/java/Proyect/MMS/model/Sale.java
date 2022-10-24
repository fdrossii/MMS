package Proyect.MMS.model;

import javax.persistence.*;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id", nullable = false)
    private Long id;

    @Column(name = "date")
    private String date;

    @OneToOne
    @JoinColumn(name = "saleDetail_id")
    private SaleDetail saleDetail;

    public Sale() {
    }

    public Sale(Long id, String date, SaleDetail saleDetail) {
        this.id = id;
        this.date = date;
        this.saleDetail = saleDetail;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public SaleDetail getSaleDetail() {
        return saleDetail;
    }

    public void setSaleDetail(SaleDetail saleDetail) {
        this.saleDetail = saleDetail;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", saleDetail=" + saleDetail +
                '}';
    }
}
