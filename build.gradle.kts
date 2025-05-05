plugins {
    kotlin("plugin.serialization") version "1.9.22" apply false
    kotlin("jvm") version "1.9.22" apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}



