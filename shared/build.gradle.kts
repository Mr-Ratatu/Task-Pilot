plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.composePlugin)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    id("dev.icerock.mobile.multiplatform-resources")
    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.datetime)
                implementation(libs.multiplatformSettings)

                // DI
                api(project.dependencies.platform(libs.koin.bom))
                api(libs.koin.core)
                api(libs.koin.compose)

                // lifecycle
                api(libs.lifecycle.viewModel)
                implementation(libs.androidx.navigation.compose)

                // Compose
                implementation(compose.ui)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)

                // Resources
                api(libs.resources.core)
                api(libs.resources.compose)

                // Database
                implementation(libs.sqldelight.coroutines.extensions)
            }
        }

        androidMain.dependencies {
            implementation(libs.kotlinx.coroutines.android)

            // Database
            implementation(libs.sqldelight.android.driver)
        }

        jvmMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.swing)
                api(compose.desktop.currentOs)

                // Database
                implementation(libs.sqldelight.desktop.driver)
            }
        }
    }

    //https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations["main"].compilerOptions.options.freeCompilerArgs.add("-Xexport-kdoc")
    }

}

android {
    namespace = "renat.task.pilot"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    databases {
        create("TaskPilotDb") {
            packageName.set("renat.task.pilot.db")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/db"))
        }
    }
}