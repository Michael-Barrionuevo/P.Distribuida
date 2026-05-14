package com.programacion.distribuida.books.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class BookDto {
    private String isbn;
    private String title;
    private double price;

    private Integer inventorySold;
    private Integer inventorySupplied;

    public List<AuthorDto> authors;
}
