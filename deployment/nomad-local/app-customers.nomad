job "book-store" {
  datacenters = ["dc1"]

  group "servers" {
    count = 2
    shutdown_delay = "15s"

    network {
      port "http" {}
    }

    task "app-customers" {

      driver = "raw_exec"

      artifact {
        source      = "https://github.com/Michael-Barrionuevo/P.Distribuida/releases/download/VERSION_1.0.0/app-customers-0.0.1-SNAPSHOT.zip"
        destination = "local/"
        mode        = "any"
      }

      config {

        command = "java"
        args    = [
          "-Xmx512m",
          "-Xms128m",
          "-jar",
          "local/app-customers-0.0.1-SNAPSHOT.jar"
        ]
      }

      env {
        SERVER_PORT = "${NOMAD_PORT_http}"
        SPRING_CLOUD_CONSUL_HOST = "172.16.89.20"
      }

      service {
        provider = "nomad"
        name     = "app-customers"
        port     = "http"
      }
    }
  }
}