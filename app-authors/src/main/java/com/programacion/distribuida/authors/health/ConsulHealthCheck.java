package com.programacion.distribuida.authors.health;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import java.net.HttpURLConnection;
import java.net.URL;

@Readiness
@ApplicationScoped
public class ConsulHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        String consulUrl = System.getProperty("consul.host", "http://localhost:8500/v1/status/leader");
        try {
            URL url = new URL(consulUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                return HealthCheckResponse.up("Consul connection");
            } else {
                return HealthCheckResponse.down("Consul returned status: " + responseCode);
            }
        } catch (Exception e) {
            return HealthCheckResponse.down("Consul is unreachable: " + e.getMessage());
        }
    }
}