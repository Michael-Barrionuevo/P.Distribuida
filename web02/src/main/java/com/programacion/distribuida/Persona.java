package com.programacion.distribuida;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Persona {

    private String name;
    private LocalDateTime hora;
}
