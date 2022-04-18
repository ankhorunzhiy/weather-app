plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.6.10"
}

dependencies {
    implementation(project(":common:network"))
    api(project(":features:weather:domain"))
    implementation(Libs.RETROFIT)
    implementation(Libs.SERIALIZATION)
    implementation(Libs.COROUTINES)
    implementation(Libs.HILT_CORE)
    kapt(Libs.HILT_CORE_COMPILER)
}