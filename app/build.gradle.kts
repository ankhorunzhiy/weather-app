plugins {
  id("com.android.application")
  id("dagger.hilt.android.plugin")
  kotlin("android")
  kotlin("kapt")
}

android {
  compileSdk = Versions.COMPILE_SDK

  defaultConfig {
    applicationId = "com.petproject.weatherapp"
    minSdk = Versions.MIN_SDK
    targetSdk = Versions.TARGET_SDK
    versionCode = Versions.VERSION_CODE
    versionName = Versions.VERSION_NAME

    vectorDrawables.useSupportLibrary = true
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
    options.jvmTarget = "1.8"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.COMPOSE
  }
  packagingOptions {
    resources.excludes.add("META-INF/AL2.0")
    resources.excludes.add("META-INF/LGPL2.1")
  }
}

dependencies {

  implementation(project(":features:cities"))
  implementation(Libs.ACTIVITY_KTX)
  implementation(Libs.ACTIVITY_COMPOSE)
  implementation(Libs.COMPOSE_MATERIAL)
  implementation(Libs.COMPOSE_RUNTIME)
  implementation(Libs.COMPOSE_TOOLING)

  //Hilt
  implementation(Libs.HILT_ANDROID)
  kapt(Libs.HILT_COMPILER)
}