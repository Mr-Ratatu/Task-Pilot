plugins {
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.kotlinx.serialization).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.sqldelight).apply(false)
}

buildscript {
    dependencies {
        classpath("dev.icerock.moko:resources-generator:0.24.0-beta-3")
    }
}
