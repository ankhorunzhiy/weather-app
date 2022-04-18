plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Versions.COMPILE_SDK
    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.COROUTINES)
    implementation(Libs.COMPOSE_RUNTIME)
    implementation(Libs.VIEWMODEL_COMPOSE)
    implementation(Libs.LIFECYCLE_RUNTIME_KTX)
}