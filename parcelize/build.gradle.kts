plugins {
    id ("org.jetbrains.kotlin.jvm")  version "1.7.0"
    id("java-gradle-plugin")
}

group = "com.example"
version = 1.0

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
}

gradlePlugin {
    plugins.create("parcelize-subplugin") {
        id = "com.example.kotlin-parcelize"
        displayName = "Kotlin Parcelize"
        description =
            "The Gradle Plugin for enabling @Parcelize annotation usage in pure Kotlin modules"
        implementationClass = "com.example.ParcelizeSubplugin"
    }
}
