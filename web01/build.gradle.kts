plugins {
    id("java")
    id("war")
}

group = "com.dos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("jakarta.ws.rs:jakarta.ws.rs-api:4.0.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.war {
    archiveFileName.set("web01.war")
}