@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("neversitup.android.library")
    id("kotlinx-serialization")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.neversitup.database"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
}