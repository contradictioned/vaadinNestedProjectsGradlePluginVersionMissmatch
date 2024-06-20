pluginManagement {
  repositories {
      maven { setUrl("https://maven.vaadin.com/vaadin-prereleases") }
      gradlePluginPortal()
  }
  plugins {
      id("com.vaadin") version "24.4.3"
  }
}

include("sub-project")

rootProject.name = "mainProject"
rootProject.buildFileName = "build.gradle.kts"

fun ProjectDescriptor.configureChildren() {
    children.first().apply {
        projectDir = file("sub-project")
        buildFileName = "sub-project.gradle.kts"
    }
}

rootProject.configureChildren()