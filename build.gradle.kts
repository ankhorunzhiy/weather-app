import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}")
    classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}")
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
  }
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
  kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi"
}