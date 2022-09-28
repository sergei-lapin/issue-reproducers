plugins { id("java") }

val projectName = name.replace('-', '_')

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8

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
