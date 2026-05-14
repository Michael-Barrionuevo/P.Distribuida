package com.programacion.distribuida.books.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@ToString//(exclude = {"book"})
public class Inventory {

    @Id
    @OneToOne
    @JoinColumn(name = "book_isbn")
    @ToString.Exclude
    private Book book;
    private int sold;
    private int supplied;
    private int version;
}
