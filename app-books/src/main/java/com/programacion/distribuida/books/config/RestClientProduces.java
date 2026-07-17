//package com.programacion.distribuida.books.config;
//
//import com.programacion.distribuida.books.clients.AuthorRestClient;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.inject.Produces;
//import jakarta.inject.Inject;
//import org.eclipse.microprofile.config.inject.ConfigProperty;
//import org.eclipse.microprofile.rest.client.RestClientBuilder;
//
//@ApplicationScoped
//public class RestClientProduces {
//
//    @Inject
//    @ConfigProperty(name = "authors.url")
//    String url;
//
//    @Produces
//    @ApplicationScoped
//    public AuthorRestClient authorRestClient() {
//        return RestClientBuilder.newBuilder()
//                .baseUri(url)
//                .build(AuthorRestClient.class);
//    }
//}
//
//Es automatico
