plugins {
    id("java")
}

group = "uce.edu.ec"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {

}

tasks.test {
    useJUnitPlatform()
}