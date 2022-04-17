plugins {
  kotlin("jvm")
  kotlin("kapt")
  kotlin("plugin.serialization") version "1.6.10"
}

dependencies {
  implementation(Libs.HILT_CORE)
  implementation(Libs.RETROFIT)
  implementation(Libs.RETROFIT_SERIALIZATION)
  implementation(Libs.OKHTTP)
  implementation(Libs.OKHTTP_LOGGER)
  implementation(Libs.SERIALIZATION)
  kapt(Libs.HILT_CORE_COMPILER)
}