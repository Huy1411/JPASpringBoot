package com.example.enterprise_application.jpa.core;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"order\"")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "mode")
    private String mode;

    @Column(name = "status")
    private int status;

    @Column(name = "total")
    private String total;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItem = new HashSet<>();

    public Order(String date, String mode, int status, String total, Employee employee, Customer customer) {
        this.date = date;
        this.mode = mode;
        this.status = status;
        this.total = total;
        this.employee = employee;
        this.customer = customer;
    }
}
