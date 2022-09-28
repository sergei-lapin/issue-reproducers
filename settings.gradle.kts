@file:Suppress("UnstableApiUsage")

pluginManagement {
  includeBuild("build-logic")
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  includeBuild("build-logic")
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "Source Sets Sample"

include(":android-app")
include(":java-lib")