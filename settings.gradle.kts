pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") } // Optional, for other GitHub-hosted libs
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    }
}

dependencyResolutionManagement{
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories{
        google()
        mavenCentral()
        gradlePluginPortal()

    }
}

rootProject.name = "MyWeatherApp"  // Update your root project name as needed
include(":app")  // Include the app module (you can add more modules here as required)
