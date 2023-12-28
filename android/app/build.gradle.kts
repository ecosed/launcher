import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dev.flutter.flutter-gradle-plugin")
}

val localProperties = File(rootDir, "local.properties")
val stream = FileInputStream(localProperties)
val reader = InputStreamReader(stream, Charsets.UTF_8)
val properties = Properties()
if (localProperties.isFile) reader.use { content ->
    properties.load(content)
} else error(message = "File from not found")
var flutterVersionCode: String? = properties.getProperty("flutter.versionCode")
var flutterVersionName: String? = properties.getProperty("flutter.versionName")

android {
    namespace = "io.ecosed.apps"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.ecosed.apps"
        minSdk = 24
        targetSdk = 34
        versionCode = flutterVersionCode?.toInt() ?: 1
        versionName = flutterVersionName ?: "1.0"
    }

    buildTypes {
        release {
            isShrinkResources = true
            isMinifyEnabled = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

flutter {
    source = "${rootProject.projectDir}/.."
}

dependencies {

}
