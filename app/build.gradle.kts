plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "pavel.ivanov.myapplication"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
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
        viewBinding = true
    }
}

dependencies {
    //Modules
    implementation(project(Modules.app))
    implementation(project(Modules.core))
    implementation(project(Modules.model))
    implementation(project(Modules.repository))
    implementation(project(Modules.utils))
    implementation(project(Modules.historyScreen))
    //Feature

    //AndroidX
    implementation(Design.appcompat)
    //Design

    implementation(Design.material)

    //Kotlin
    implementation(Kotlin.core)
    implementation(Kotlin.stdlib)
    implementation(Kotlin.coroutines_core)
    implementation(Kotlin.coroutines_android)

    //Koin for Android
    implementation(Koin.koin_android)
    implementation(Koin.koin_view_model)
    implementation(Koin.test_compile)
    implementation(Koin.koin_view_model_x)

    //Room
    implementation(Room.runtime)
    kapt(Room.compiler)
    implementation(Room.room_ktx)

    //Coil
    implementation(Coil.coil)

    //Test
    testImplementation(TestImpl.junit)
    androidTestImplementation(TestImpl.runner)
    androidTestImplementation(TestImpl.espresso)
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.core:core-splashscreen:1.0.0-beta02")
}

repositories {
//    mavenCentral()
}
