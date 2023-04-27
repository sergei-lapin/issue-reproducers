plugins {
    kotlin("jvm") version "1.8.20"
    id("com.squareup.wire") version "4.5.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

wire {
    kotlin { }
}

dependencies {
    implementation(project(":proto-lib-2"))
    protoPath(project(":proto-lib-2"))
}

kotlin {
    jvmToolchain(17)
}