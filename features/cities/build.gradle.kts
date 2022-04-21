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
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.COMPOSE
  }
  kotlinOptions.jvmTarget = "1.8"
}

dependencies {
  implementation(project(":features:cities:data"))
  implementation(project(":common:flowui"))
  implementation(project(":common:flowbinding"))
  implementation(project(":common:dispatchers:core"))
  implementation(project(":common:navigation"))
  //Compose
  implementation(Libs.ACTIVITY_COMPOSE)
  implementation(Libs.CORE_KTX)
  implementation(Libs.COMPOSE_RUNTIME)
  implementation(Libs.COMPOSE_TOOLING_PREVIEW)
  implementation(Libs.COMPOSE_MATERIAL)
  implementation(Libs.COMPOSE_NAVIGATION)
  //Coroutines
  implementation(Libs.COROUTINES)
  //ViewModel
  implementation(Libs.VIEWMODEL_COMPOSE)
  //Hilt
  implementation(Libs.HILT_NAVIGATION)
  implementation(Libs.HILT_ANDROID)
  kapt(Libs.HILT_COMPILER)
}
