plugins {
    kotlin("jvm") version "1.8.20"
    id("com.squareup.wire") version "4.5.3"
}

group = "org.example"
version = "1.0-SNAPSHOT"

wire {
    protoLibrary = true
    kotlin { }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}