plugins {
  kotlin("jvm")
  kotlin("kapt")
}

dependencies {
  implementation(Libs.COROUTINES)
  implementation(Libs.KOTLIN_STDLIB)
  implementation(Libs.HILT_CORE)
  kapt(Libs.HILT_CORE_COMPILER)
}