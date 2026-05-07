package com.programacion.distribuida;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.time.LocalDateTime;

@Path("/hola")
public class HolaRest {

    @GET
    @Path("/{name}")
    @Produces
    public String hola(@PathParam("name") String name) {
        return "Hola" + name + " " + LocalDateTime.now();
    }
}
