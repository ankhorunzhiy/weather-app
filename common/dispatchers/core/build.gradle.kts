plugins {
  kotlin("jvm")
  kotlin("kapt")
}



dependencies {
  api(project(":common:dispatchers"))
  implementation(Libs.COROUTINES)
  implementation(Libs.HILT_CORE)
  kapt(Libs.HILT_CORE_COMPILER)
}