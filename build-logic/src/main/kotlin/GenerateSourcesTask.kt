import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.work.DisableCachingByDefault

@DisableCachingByDefault(because = "Not worth caching")
abstract class GenerateSourcesTask : DefaultTask() {

  @get:Input abstract val packageName: Property<String>

  @get:OutputDirectory abstract val outputDir: DirectoryProperty

  @TaskAction
  fun run() {
    val packageName = packageName.get()
    val triggerCode =
      """
            package $packageName;
            
            class GeneratedSource {}
      """
        .trimIndent()
    val outputFile =
      outputDir.get().asFile.resolve("${packageName.replace('.', '/')}/GeneratedSource.java")
    outputFile.parentFile?.mkdirs()
    outputFile.writeText(triggerCode)
  }
}
