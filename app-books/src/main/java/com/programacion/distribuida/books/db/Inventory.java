package com.programacion.distribuida.books.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inventory")
@Getter
@Setter
public class Inventory {

    @Id
    private String book_isbn;
    private int sold;
    private int supplied;
    private int version;
}
