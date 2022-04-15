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
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.COMPOSE
  }
  kotlinOptions.jvmTarget = "1.8"
}

dependencies {
  //Compose
  implementation(Libs.ACTIVITY_COMPOSE)
  implementation(Libs.CORE_KTX)
  implementation(Libs.COMPOSE_RUNTIME)
  implementation(Libs.COMPOSE_TOOLING_PREVIEW)
  implementation(Libs.COMPOSE_MATERIAL)
  //ViewModel
  implementation(Libs.VIEWMODEL_COMPOSE)
  //Hilt
  implementation(Libs.HILT_ANDROID)
  kapt(Libs.HILT_COMPILER)
}
