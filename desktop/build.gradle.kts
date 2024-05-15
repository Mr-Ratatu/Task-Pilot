plugins {
    alias(libs.plugins.composePlugin)
    alias(libs.plugins.multiplatform)
}

kotlin {
    jvm("desktop")

    sourceSets {
        val desktopMain by getting {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }

}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}