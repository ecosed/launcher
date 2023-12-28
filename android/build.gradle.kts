plugins {
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
    id("dev.rikka.tools.refine") version "4.3.0" apply false
}

allprojects {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://jitpack.io")
        mavenLocal()
    }
}

rootProject.buildDir = File("../build")

subprojects {
    project.buildDir = File("${rootProject.buildDir.name}/${project.name}")
    project.evaluationDependsOn(":app")
}