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
public class InventoryID implements Serializable {
    @Column(name = "wareHouseId")
    private int wareHouseId;

    @Column(name = "productId")
    private int productId;
}
