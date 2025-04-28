// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
    }

    dependencies {
       // classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.1")
    }
}


plugins {
    id("com.android.application") version "8.9.2" apply false
    id("com.android.library") version "8.9.2" apply false
    //id("org.jetbrains.kotlin.android") version "1.5.31" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
    stabilityConfigurationFile = rootProject.layout.projectDirectory.file("stability_config.conf")
}
