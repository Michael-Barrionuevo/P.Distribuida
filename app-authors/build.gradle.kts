plugins {
    id("java")
    id("io.quarkus") version "3.35.2"
    id("io.freefair.lombok") version "9.2.0"
}

group = "uce.edu.ec"
version = "unspecified"

repositories {
    mavenCentral()
}

val quarkusVersion = "3.35.2"

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}


dependencies {
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:$quarkusVersion"))

    //CDI
    implementation("io.quarkus:quarkus-arc")


    //REST
    implementation("io.quarkus:quarkus-rest")
    implementation("io.quarkus:quarkus-rest-jsonb")
    implementation("io.quarkus:quarkus-hibernate-orm")
    implementation("io.quarkus:quarkus-hibernate-orm-panache")
    implementation("io.quarkus:quarkus-jdbc-postgresql")

    //FLYWAY
    implementation("io.quarkus:quarkus-flyway:3.35.2")
    runtimeOnly("org.flywaydb:flyway-database-postgresql:12.5.0")
}

tasks.test {
    useJUnitPlatform()
}