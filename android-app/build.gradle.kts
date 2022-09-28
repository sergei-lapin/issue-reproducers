@file:Suppress("UnstableApiUsage")

plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
}

val projectName = name.replace('-', '_')

android {
  compileSdk = 32
  defaultConfig {
    applicationId = "com.example.sourcesetssample"
    minSdk = 21
    targetSdk = 32
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions { jvmTarget = JavaVersion.VERSION_1_8.toString() }

  sourceSets.configureEach {
    val sourceSetName = name
    val generatedDir = layout.buildDirectory.dir("generated/sources/tool/$sourceSetName")
    val generateTask =
      tasks.register<GenerateSourcesTask>("generateFor${sourceSetName.capitalize()}") {
        packageName.set("$projectName.$sourceSetName")
        outputDir.set(generatedDir)
      }
    java.srcDirs(generateTask.flatMap(GenerateSourcesTask::outputDir))
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.7.0")
  implementation("androidx.appcompat:appcompat:1.5.1")
  implementation("com.google.android.material:material:1.6.1")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
