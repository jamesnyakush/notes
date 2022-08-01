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
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.5.31" apply false
}
