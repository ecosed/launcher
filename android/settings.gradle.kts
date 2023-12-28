pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://jitpack.io")
        mavenLocal()
    }

    fun getFlutter(): String {
        val localProperties = File(rootDir, "local.properties")
        val stream = java.io.FileInputStream(localProperties)
        val reader = java.io.InputStreamReader(stream, Charsets.UTF_8)
        val properties = java.util.Properties()
        val flutterProp = "flutter.sdk"
        val gradlePath = "/packages/flutter_tools/gradle"

        return when {
            localProperties.isFile -> reader.use { content ->
                properties.load(content)
                properties.getProperty(flutterProp) + gradlePath
            }

            else -> error(message = "File from not found")
        }
    }

    includeBuild(getFlutter())

    plugins {
        id("dev.flutter.flutter-gradle-plugin") version "1.0.0" apply false
        id("dev.flutter.flutter-plugin-loader") version "1.0.0"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://jitpack.io")
        mavenLocal()
    }
}
rootProject.name = "EcosedLauncher"
include(":app")
