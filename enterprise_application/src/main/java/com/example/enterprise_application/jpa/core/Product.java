package com.example.enterprise_application.jpa.core;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "productName")
    @Size(min = 5,max = 255)
    private String productName;

    @Column(name = "\"desc\"")
    @Size(min = 5,max = 60)
    private String desc;

    @Column(name = "weightClass")
    private String weightClass;

    @Column(name = "status")
    @Min(value = 1,message = "Please chose a status")
    private int status;

    @Column(name = "listPrice")
    private Double listPrice;

    @Column(name = "minPrice")
    private Double minPrice;

    @Column(name = "catalogUrl")
    private String catalogUrl;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItem = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Inventory> inventory = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductDescription> productDescription = new HashSet<>();

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public String getCatalogUrl() {
        return catalogUrl;
    }

    public void setCatalogUrl(String catalogUrl) {
        this.catalogUrl = catalogUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Set<OrderItem> orderItem) {
        this.orderItem = orderItem;
        for (OrderItem b: orderItem){
            b.setProduct(this);
        }
    }

    public Set<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(Set<Inventory> inventory) {
        this.inventory = inventory;
        for (Inventory b: inventory){
            b.setProduct(this);
        }
    }

    public Set<ProductDescription> getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(Set<ProductDescription> productDescription) {
        this.productDescription = productDescription;
        for (ProductDescription b: productDescription){
            b.setProduct(this);
        }
    }
}
