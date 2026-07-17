package com.programacion.distribuida.authors.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;
import java.time.LocalDateTime;

@Path("/hola")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HolaRest {

    @GET
    public String hola() {
        return "Hola Mundo" + LocalDateTime.now();
    }
}
