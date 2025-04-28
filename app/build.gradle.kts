plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
}

android {
    compileSdk = 35

    namespace = "com.jamesnyakush.notes"
    testNamespace = "com.example.mytestapp"

    defaultConfig {
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
}



dependencies {
    implementation( "org.jetbrains.kotlin:kotlin-stdlib-jdk7:2.1.0")
    implementation("androidx.core:core-ktx:1.16.0")
    implementation(platform("androidx.compose:compose-bom:2025.04.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview:1.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.10.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.8.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.8.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.8.0")


    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")

    implementation("androidx.navigation:navigation-compose:2.8.9")
    implementation("com.jakewharton.timber:timber:5.0.1")

    implementation( "androidx.room:room-ktx:2.7.1")
    implementation("androidx.room:room-runtime:2.7.1")
    kapt("androidx.room:room-compiler:2.7.1")


    implementation("io.insert-koin:koin-core:4.0.4")
    implementation("io.insert-koin:koin-android:4.0.4")
    implementation("io.insert-koin:koin-androidx-compose:4.0.4")
}