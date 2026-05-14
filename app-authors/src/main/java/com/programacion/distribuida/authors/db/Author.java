package com.programacion.distribuida.authors.db;

import com.programacion.distribuida.books.db.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

//    @ManyToMany
//    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "authors_id"), inverseJoinColumns = @JoinColumn(name = "books_isbn"))
//    private List<Book> books;
}
