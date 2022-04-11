plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")

    // Rx-Java
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")
    implementation("io.reactivex.rxjava2:rxjava:2.2.8")

    // Retrofit 2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.2")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")

    // Dagger
    implementation("com.google.dagger:dagger-android:2.35.1")
    implementation("com.google.dagger:dagger-android-support:2.35.1")
    kapt("com.google.dagger:dagger-android-processor:2.35.1")
    kapt("com.google.dagger:dagger-compiler:2.39.1")

    // Koin
    // Основная библиотека
    implementation(Dependencies.KTX_KOIN_CORE)
    // Koin для поддержки Android (Scope,ViewModel ...)
    implementation(Dependencies.KTX_KOIN_ANDROID)
    // Для совместимости с Java
    implementation(Dependencies.KTX_KOIN_ANDROID_COMPAT)

    // Coroutines
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    // Picasso
    implementation("com.squareup.picasso:picasso:2.71828")
    
    // Glide
    implementation(Dependencies.KTX_GLIDE)
    kapt(Dependencies.KTX_GLIDE_COMPILER)

    // Coil
    implementation("io.coil-kt:coil:0.11.0")

    // SwipeRefreshLayout
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Room
    implementation(Dependencies.KTX_ROOM_RUNTIME)
    implementation(Dependencies.KTX_ROOM_KTX)
    kapt(Dependencies.KTX_ROOM_COMPILER)

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}