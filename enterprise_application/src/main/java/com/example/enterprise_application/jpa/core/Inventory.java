package com.example.enterprise_application.jpa.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Inventory")
public class Inventory {

    @EmbeddedId
    private InventoryID id;

    @ManyToOne
    @MapsId("wareHouseId")
    @JoinColumn(name = "wareHouseId")
    private WareHouse wareHouse;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    private ProductInformation product;

    @Column(name = "qtyOnHand")
    private int qtyOnHand;

    public Inventory(WareHouse wareHouse, ProductInformation product, int qtyOnHand) {
        this.id = new InventoryID(wareHouse.getId(),product.getId());
        this.wareHouse = wareHouse;
        this.product = product;
        this.qtyOnHand = qtyOnHand;
    }
}
