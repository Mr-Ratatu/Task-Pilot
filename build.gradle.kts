plugins {
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.kotlinx.serialization).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
}

//buildscript {
//    repositories {
//        gradlePluginPortal()
//    }
//
//    dependencies {
//        classpath(libs.resources.core)
//    }
//}
