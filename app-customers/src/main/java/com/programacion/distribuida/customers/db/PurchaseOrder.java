package com.programacion.distribuida.customers.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_orders")
@Getter
@Setter
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime deliveredon;
    private LocalDateTime placedon;
    private int status;
    private int total;
    private Integer customer_id;

}
