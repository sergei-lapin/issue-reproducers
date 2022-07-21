package com.example

import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.*

class ParcelizeSubplugin : KotlinCompilerPluginSupportPlugin {

  override fun apply(target: Project) {
    target.dependencies.add(
        "implementation",
        "org.jetbrains.kotlin:kotlin-parcelize-runtime:1.7.0",
    )
  }

  override fun applyToCompilation(
      kotlinCompilation: KotlinCompilation<*>,
  ): Provider<List<SubpluginOption>> = kotlinCompilation.target.project.provider { emptyList() }

  override fun getCompilerPluginId(): String = "org.jetbrains.kotlin.parcelize"

  override fun getPluginArtifact(): SubpluginArtifact =
      JetBrainsSubpluginArtifact(artifactId = "kotlin-parcelize-compiler")

  override fun isApplicable(
      kotlinCompilation: KotlinCompilation<*>,
  ): Boolean = true
}
