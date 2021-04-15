package com.example.enterprise_application.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "orderDate")
    private String orderDate;

    @Column(name = "orderMode")
    private String orderMode;

    @Column(name = "orderStatus")
    private int orderStatus;

    @Column(name = "orderTotal")
    private String orderTotal;


    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItem = new HashSet<>();

    public Order(String orderDate, String orderMode, int orderStatus, String orderTotal, Employee employee, Customer customer) {
        this.orderDate = orderDate;
        this.orderMode = orderMode;
        this.orderStatus = orderStatus;
        this.orderTotal = orderTotal;
        this.employee = employee;
        this.customer = customer;
    }
}
