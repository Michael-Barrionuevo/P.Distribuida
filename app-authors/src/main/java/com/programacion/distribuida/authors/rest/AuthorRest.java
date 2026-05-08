package com.programacion.distribuida.authors.rest;

import com.programacion.distribuida.authors.db.Author;
import com.programacion.distribuida.authors.repo.AuthorRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorRest {

    @Inject
    AuthorRepository authorRepository;

    @Inject
    @ConfigProperty(name = "quarkus.http.port")
    Integer httpPort;

    @GET
    public List<Author> getAll() {
        return authorRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
//        var obj = authorRepository.findByIdOptional(id);
//        if (obj.isPresent()) {
//            return Response.ok(obj.get()).build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }

        return authorRepository.findByIdOptional(id)
                .map(it -> {
                    it.setName(it.getName() + " - " + httpPort);
                    return it;
                })
                .map(Response::ok).orElse(Response.status(Response.Status.NOT_FOUND)).build();
    }
}

