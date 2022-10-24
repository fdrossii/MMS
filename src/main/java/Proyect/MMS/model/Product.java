package Proyect.MMS.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
     private Long id;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "name")
    private String name;
    @Column(name = "price", scale = 2)
    private Double price;
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    public Product() {
    }

    public Product(Long id, String manufacturer, String name, Double price, Long quantity) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}