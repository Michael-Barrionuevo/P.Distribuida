package com.programacion.distribuida.customers.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "line_items")
@Getter
@Setter

public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private int quantity;
    private String book_isbn;
    private Integer order_id;

}
