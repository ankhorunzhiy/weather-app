plugins {
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    api(project(":common:usecase"))
    implementation(project(":common:dispatchers"))
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.COROUTINES)
    implementation(Libs.HILT_CORE)
    kapt(Libs.HILT_CORE_COMPILER)
}