plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Versions.COMPILE_SDK
    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
    }

    packagingOptions {
        resources.excludes.add("META-INF/licenses/**")
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(Libs.COROUTINES)
    implementation(Libs.COROUTINES_ANDROID)
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.HILT_ANDROID)
    kapt(Libs.HILT_COMPILER)
}