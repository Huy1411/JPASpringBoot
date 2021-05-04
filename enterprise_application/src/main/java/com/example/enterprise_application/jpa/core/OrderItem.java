package com.example.enterprise_application.jpa.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "OrderItem")
public class OrderItem {
    @EmbeddedId
    private OrderItemID id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    private ProductInformation product;

    @Column(name = "unitPrice")
    private Double unitPrice;

    @Column(name = "\"qty\"")
    private int qty;

    public OrderItem (Order order, ProductInformation product, Double unitPrice, int qty) {
        this.id = new OrderItemID(order.getId(),product.getId());
        this.order = order;
        this.product = product;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }
}
