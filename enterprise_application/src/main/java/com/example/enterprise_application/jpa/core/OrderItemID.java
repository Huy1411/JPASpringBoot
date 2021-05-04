package com.example.enterprise_application.jpa.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderItemID implements Serializable {
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "productId")
    private Integer productId;

}

