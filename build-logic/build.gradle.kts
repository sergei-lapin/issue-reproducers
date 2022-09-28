plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    id("java-gradle-plugin")
}

dependencies {
    compileOnly(gradleApi())
}

gradlePlugin {
    plugins.create("build-logic-classloader") {
        id = "build-logic-classloader"
        implementationClass = "ClassLoadingPlugin"
    }
}
