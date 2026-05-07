plugins {
    id("java")
    id("io.freefair.lombok") version "9.2.0"
    //id('application')
    //id('io.helidon.build.maven-plugin')
    id("com.gradleup.shadow") version "9.3.0"
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

val helidonVersion = "4.4.1"

dependencies {
    implementation("io.helidon.webserver:helidon-webserver:$helidonVersion")
    implementation("io.helidon.http.media:helidon-http-media-jsonp:$helidonVersion")
    implementation("io.helidon.http.media:helidon-http-media-jsonb:$helidonVersion")

    runtimeOnly("io.helidon.config:helidon-config-yaml:$helidonVersion")

    implementation("io.helidon.dbclient:helidon-dbclient:$helidonVersion")
    implementation("io.helidon.dbclient:helidon-dbclient-jdbc:$helidonVersion")
    implementation("io.helidon.dbclient:helidon-dbclient-hikari:$helidonVersion")

    implementation("org.postgresql:postgresql:42.7.11")
}

tasks.jar {
    manifest {
        attributes[
            "Main-Class"] = "com.programacion.distribuida.MiAplicacionMain"

    }
}

tasks.shadowJar {
    mergeServiceFiles()
}