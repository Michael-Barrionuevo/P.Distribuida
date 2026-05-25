package com.programacion.distribuida.authors;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.vertx.core.Vertx;
import io.vertx.ext.consul.CheckOptions;
import io.vertx.ext.consul.ConsulClient;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.ext.consul.ServiceOptions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.net.InetAddress;


@ApplicationScoped
public class AuthorLifecycle {
    @Inject
    @ConfigProperty(name = "consul.host", defaultValue = "127.0.0.1")
    String consultHost;

    @Inject
    @ConfigProperty(name = "consul.posrt", defaultValue = "8500")
    Integer consulPort;

    @Inject
    @ConfigProperty(name = "quarkus.http.port", defaultValue = "8070")
    Integer appPort;

    String ipAddress;
    String serviceId;

    public void init(@Observes StartupEvent event, Vertx vertx) {
        try {
            System.out.println("AuthorsLifeCycle init");
            ConsulClientOptions options = new ConsulClientOptions()
                    .setHost(consultHost)
                    .setPort(consulPort);
            ConsulClient client = ConsulClient.create(vertx, options);
            String ipAddress = InetAddress.getLocalHost().getHostAddress();

            serviceId = "app-authors-%s:%d".formatted(ipAddress, appPort);

            var urlCheck = "http://%s:%d/ping".formatted(ipAddress, appPort);
            CheckOptions checkOptions = new CheckOptions()
                    .setHttp(urlCheck)
                    .setInterval("10s")
                    .setDeregisterAfter("10s");

            ServiceOptions serviceOptions = new ServiceOptions()
                    .setName("app-authors")
                    .setId(serviceId)
                    .setAddress(ipAddress)
                    .setPort(appPort)
                    .setCheckOptions(checkOptions);


            client.registerService(serviceOptions)
                    .onSuccess(it -> System.out.println("Authors service registered in consul with ID" + serviceId))
                    .onFailure(it -> {
                        System.out.println("Failed to register Authors service in consul: ");
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void destroy(@Observes ShutdownEvent event, Vertx vertx) {

        System.out.println("AuthorsLifeCycle destroy");
        ConsulClientOptions options = new ConsulClientOptions()
                .setHost(consultHost)
                .setPort(consulPort);
        ConsulClient client = ConsulClient.create(vertx, options);
        client.deregisterService(serviceId)
                .onSuccess(it -> System.out.println("Authors service deregister from Consul with ID: " + serviceId))
                .onFailure(it -> System.out.println("Failed to deregister Authors service from Consul" + it.getMessage()));

    }

}
