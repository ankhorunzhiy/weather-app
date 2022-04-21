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
  kotlinOptions.jvmTarget = "1.8"
}

dependencies {
  api(project(":common:dispatchers"))
  implementation(Libs.COROUTINES)
  implementation(Libs.COROUTINES_ANDROID)
  implementation(Libs.HILT_CORE)
  kapt(Libs.HILT_CORE_COMPILER)
}