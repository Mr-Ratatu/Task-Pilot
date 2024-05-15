pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Task-Pilot"
include(":desktop")
include(":shared")
includeBuild("convention-plugins")
include(":androidApp")
