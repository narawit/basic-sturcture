@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("kotlin")
    id("kotlinx-serialization")
}

dependencies {
    api(libs.kotlinx.serialization.json)
}