package com.programacion.distribuida.books.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private Integer id;
    private String name;
}
